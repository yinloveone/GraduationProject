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
            let file = {uri: params.path, type: 'application/octet-stream', name: 'image.jpg'};
            formData.append("file", file);
            fetch(common_url + url, {
                method: 'POST',
                headers: {
                    'Content-Type': 'multipart/form-data;charset=utf-8',
                    "x-access-token": token,
                },//欢迎加入前端全栈开发交流圈一起学习交流：864305860
                body: formData,
            }).then((response) => response.json())
                .then((responseData)=> {
                   console.log('uploadImage', responseData);
                    resolve(responseData);
                })
                .catch((err)=> {
                    console.log('err', err);
                    reject(err);
                });
        });
    }
}