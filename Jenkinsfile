// pipeline {
//     agent any
//     tools {
//         maven 'Maven 3.8.4'
//     }
//     stages {

//         stage('Get the Repo')
//         {
//             steps{
//                 bat 'git clone "https://github.com/anirudhk999/java_sorting_algorithms"'
//             }
//         }
//         stage('Build') {
//             steps {
//                 bat 'mvn -B -DskipTests clean package'
//             }
//         }
//         stage('Run Unit Tests') {
//             steps 
//             {
//                 // Compile the Java code and run the unit tests on Windows
//                 bat 'mvn test'

//             }
//         }

//         post
//         {
//             always{
//                 cleanWs()
//             }
//         }
        

//     }
// }

pipeline {
    agent any
 
    tools {
        maven 'Maven 3.8.4'
    }
 
    stages {
        stage('Checkout') {
            steps {
                git 'https://github.com/anirudhk999/final_pipeline_job'
            }
        }
 
        stage('Build') {
            steps {
                bat 'mvn clean package -DskipTests'
            }
        }
 
        stage('Run App.java') {
            steps {
                bat 'java -cp target\\classes sortingalgo.App'
            }
        }
 
        stage('Unit Tests') {
            steps {
                bat 'mvn test'
            }
        }

        stage('Setup Python')
        {
            steps{
                bat 'python -m venv venv2'
                bat '.\\venv2\\Scripts\\activate'
            }
        }
        
        stage('Install All Dependencies')
        {
            steps{
                bat 'pip install -r "C:\\Project_J\\project_j\\src\\requirements.txt"'
            }
        }
        
        stage('Run Tests')
        {
            steps
            {
                bat 'python -m pytest "C:\\Project_J\\project_j\\test\\test.py"'
            }
        }
    }
 
        // stage('SonarQube Analysis') {
        //     steps {
        //         withSonarQubeEnv('SonarQube') {
        //             sh 'mvn sonar:sonar'
        //         }
        //     }
        // }

 
    post {
        always
        {
            bat '.\\venv2\\Scripts\\deactivate'
            cleanWs()
        }
        // failure 
        // {
        //     mail to: 'developers@yourcompany.com',
        //          subject: "Failed Pipeline: ${currentBuild.fullDisplayName}",
        //          body: "Something is wrong with ${env.BUILD_URL}"
        // }
    }
}
