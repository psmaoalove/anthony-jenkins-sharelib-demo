
def call(int a, int b) {
    
pipeline {
    agent  any
    libraries{
        lib('devops-demo')
    }
    stages {
        //下载代码
        stage("GetCode"){ //阶段名称
            steps{  //步骤
script{
    result =TwoNumberAdd 3,5
    println result
}
            }
        }
    }

}

}
