pipeline {
    agent any
    stages {     
        stage('Build') {
            steps {
                echo 'Building'
                sh 'mvn clean install'
            }
        }
        stage('Test') {
            steps {
                echo 'Testing'
                sh 'mvn clean verify sonar:sonar'
            }
        }
        stage('Deploy') {
            steps {
                echo 'Deploying'
            }
        }
    }
}
