let common_url = 'http://47.100.239.1:8080'; //服务器地址
let token = '';  //用户登陆后返回的token
export default class HttpUtil{


    static get(url){
        return new Promise((resolve,reject)=>{
            fetch(url).then(response=>response.json()).then(result=>{
                resolve(result)
            }) .catch(error=>{
                reject(error)
            })
        })
    }

    static post(url,data){
        return new Promise((resolve,reject)=>{
            fetch(url,{
                method:'POST',
                header:{
                    'Accept':"application/json",
                    'Content-Type':"application/json"
                },
                body:JSON.stringify(data)
            })
                .then(response=>response.json())
                .then(result=>{
                    resolve(result)
                })
                .catch(error=>{
                    reject(error)
                })
        })
    }
    static uploadImage(url,params){
        return new Promise(function (resolve, reject) {
            let formData = new FormData();
            for (let key in params){
                formData.append(key, params[key]);
            }
            let file = {uri: params.file, type: 'application/octet-stream', name: 'image.jpg'};
            formData.append("file", file);
            fetch(common_url + url, {
                method: 'POST',
                headers: {
                    'Accept':"application/json",
                    'Content-Type':"application/json"
                },
                body: formData,
            }).then((response) => response.json())
                .then((result)=> {
                   console.log('uploadImage', result);
                    resolve(result);
                })
                .catch((error)=> {
                    console.log('err', error);
                    reject(error);
                });
        });
    }

    static  uploadFile(url, fileUrl,fileName) {
        //这里要注意，把当前this，存储下来。
       // let thisObj = this;
        //可以忽略，就是过度效果。
     //   thisObj.setState({ spinner: true });
        let formData = new FormData();
        formData.append('file', {
            uri: fileUrl,
            name: fileName,
            type: 'image/jpeg'
        });

        const fetchOptions = {
            method: 'POST',
            body: formData
        };

        fetch(url,fetchOptions).
        then(function(response) {
            return response.json();
        }).then(function(data) {
            let url = 'http://47.100.239.1:8080'+data.data;
            console.log(url)
        }).catch(function(e) {
            console.info(e);
        });
    }
}