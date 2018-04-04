node{    

    // 镜像中进行单元测试  
  stage('unit testing'){   
    // 启动golnag:1.7并在golang内编译代码  
    docker.image('maven:3.3.3-jdk-8').inside {  
      sh 'mvn -B clean install'
      echo 'done maven'
    }  
  }  

}  
