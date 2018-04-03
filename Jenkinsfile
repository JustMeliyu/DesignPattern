node{  
    // 镜像中进行单元测试
  stage('unit testing'){ 
    // 启动golnag:1.7并在golang内编译代码
    docker.image('golang:1.7').inside {
      sh './script/unittest.sh'
    }
  }
  
  // 镜像中代码构建
  stage('Build'){    

    def confFilePath = 'conf/app.conf'
    def config = readFile confFilePath

    writeFile file: confFilePath, text: config
    
    // 启动golnag:1.7并在golang内编译代码
    docker.image('golang:1.7').inside {
      sh './script/build.sh'
    }
  }
  
  // 编译镜像并push到仓库
  def imagesName = '192.168.18.250:5002/ufleet/uflow:v0.9.1.${BUILD_NUMBER}'  
  stage('Image Build And Push'){
    docker.withRegistry('http://192.168.18.250:5002', 'registry-credentials-id') {
      docker.build(imagesName).push()
    }
  }
  
  // 启动刚运行的容器
  stage('deploy iamegs'){    
    // 需要删除旧版本的容器，否则会导致端口占用而无法启动。
    try{
      sh 'docker rm -f cicdDemo'
    }catch(e){
        // err message
    }
    docker.image(imagesName).run('-p 9091:80 --name cicdDemo') 
  }
}
