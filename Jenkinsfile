node{  
    // 镜像中进行单元测试
  stage('unit testing'){ 
    // 启动golnag:1.7并在golang内编译代码
    docker.image('golang:1.7').inside {
      sh 'pip install maven'
    }
  }
  
  // 镜像中代码构建
  stage('Build'){    

    def confFilePath = 'conf/app.conf'
    def config = readFile confFilePath

    writeFile file: confFilePath, text: config
    
    // 启动golnag:1.7并在golang内编译代码
    docker.image('golang:1.7').inside {
      sh 'mvn test'
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
