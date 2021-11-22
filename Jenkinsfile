pipeline{
    agent any
     tools {
        maven "default"
    }
    stages
    {
        stage('checkout'){
       steps{
           git branch:'master',url: 'https://github.com/BirenAmanta/Comprehensive.git'
        }
        }
        stage('Build')
        {
            steps
            {
                bat 'mvn clean compile'
            }
        }
        stage('Test')
        {
            steps
            {
                bat 'mvn test'
                junit '**/target/surefire-reports/TEST-*.xml'
            }
        }
    }
      
}