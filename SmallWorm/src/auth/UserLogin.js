import React, { Component } from 'react'
import {
    View,
    Text,
    TextInput,
    ScrollView,
    TouchableOpacity,
    Modal,
    Dimensions,
    ToastAndroid
} from 'react-native'
import Icon from "react-native-vector-icons/Ionicons";
import {
    seagreen,
    royalblue,
    white,
    mediumseagreen,
    firebrick,
    lightgray
}from 'color-disk'
import TabBar from "./TopBar";
//import navigationUtil from "../utils/navigationUtil"
import storage from '../utils/StorageUtil'

const DeviceWidth = Dimensions.get('window').width;
const DeviceHeight = Dimensions.get('window').height;
class UserLogin extends Component {
    state = {};
    constructor(props){
        super(props)
        this.state={
            email:'',
            password:'',
            errorEmail:'',
            errorPass:''
        }
    }
    componentDidMount(){
        if(this.state.email=== ''){
            this.setState({
                errorEmail: '请输入邮箱'
            })
        }else if(this.state.email!==''){
            this.setState({
                errorEmail:''
            })
        }
    }
    handleChange=()=>{
        if(this.state.email===''){
            this.setState({
                errorEmail:'请输入邮箱'
            })
        }else if(this.state.email!==''){
            this.setState({
                errorEmail:''
            })
        }
        if(this.state.password===''){
            this.setState({
                errorPass:'请输入密码'
            })
        }else if(this.state.password!==''){
            this.setState({
                errorPass:''
            })
        }
    }
    handleClose=() =>{
      //  navigationUtil.reset(this.props.navigation, 'UserRegister');
    }
    handleLogin = () => {
        const user = {
            email: this.state.email,
            password: this.state.password
        };
        const self = this;

        fetch('http://192.168.43.4:8080/login', {
            headers: {
                'content-type': 'application/json'
            },
            method: 'POST',
            cache: 'no-cache',
            mode: 'cors',
            body: JSON.stringify(user)
        }).then((response) => {
            return response.json();
        }).then((json) => {

            if (json.status == 0) {
               // const keyValuePairs = [['email', self.state.email], ['password', self.state.password]]
                let key='userInfo-'+this.state.email;
                storage.set(key, {'info': user});

           /*     AsyncStorage.multiSet(keyValuePairs, function(errs){
                    if(errs){
                        //TODO：存储出错
                        return;
                    }
                  //  navigationUtil.reset(self.props.navigation, 'Main');
                });*/
            } else {
                ToastAndroid.show('登录失败', ToastAndroid.SHORT);
            }
        })
            .catch(err => {
                console.log(err)
            })
    }


    render(){
        return(
            <Modal animationType="slide"
                   transparent={false}
                   style={{
                       backgroundColor:'rgb(233,233,238)',
                       height :DeviceHeight
                   }}
            >
                <View style={{backgroundColor:'rgb(233,233,238)'}}>
                    <TabBar title="登陆"/>
                    <ScrollView
                        contentContainerStyle={{ height: DeviceHeight }}
                    >
                        <View
                            style={{
                                justifyContent: 'center',
                                padding: DeviceWidth * 0.05
                            }}
                        >
                            <View style={{ justifyContent: 'center' }}>
                                <View
                                    style={{
                                        borderColor: seagreen,
                                        borderWidth: 1,
                                        borderRadius: 100,
                                        flexDirection: 'row',
                                        alignItems: 'center'
                                    }}
                                >
                                    <Icon name="ios-mail" size={20} color={seagreen} style={{ marginLeft: 10 }}/>
                                    <TextInput
                                        style={{
                                            height: 40,
                                            fontSize: 16,
                                            marginLeft: 4,
                                            flex: 1
                                        }}
                                        placeholder="输入邮箱"
                                        onChangeText={email =>
                                            this.setState({ email }, () => {
                                                if (this.state.email === '') {
                                                    this.setState({
                                                        errorEmail:
                                                            '请输入邮箱, '
                                                    })
                                                } else if (
                                                    this.state.email !== ''
                                                ) {
                                                    this.setState({
                                                        errorEmail: ''
                                                    })
                                                }
                                            })
                                        }
                                        value={this.state.email}
                                        onChange={this.handleChange}
                                    />

                                </View>
                                <View
                                    style={{
                                        justifyContent: 'center',
                                        marginTop: 10,
                                        height: 15
                                    }}
                                >
                                    <Text
                                        style={{
                                            color: firebrick,
                                            fontSize: 12
                                        }}
                                    >
                                        {this.state.errorEmail}
                                    </Text>
                                </View>

                                <View
                                    style={{
                                        marginTop: 15,
                                        borderColor: seagreen,
                                        borderWidth: 1,
                                        borderRadius: 100,
                                        flexDirection: 'row',
                                        alignItems: 'center'
                                    }}
                                >
                                    <Icon name="ios-lock" style={{ marginLeft: 10 }} size={20} color={seagreen} />

                                    <TextInput
                                        style={{
                                            height: 40,
                                            fontSize: 16,
                                            marginLeft: 4,
                                            flex: 1
                                        }}
                                        secureTextEntry={true}
                                        placeholder="输入密码"
                                        onChangeText={password =>
                                            this.setState({ password }, () => {
                                                if (
                                                    this.state.password === ''
                                                ) {
                                                    this.setState({
                                                        errorPass:
                                                            '请输入密码, '
                                                    })
                                                } else if (
                                                    this.state.password !== ''
                                                ) {
                                                    this.setState({
                                                        errorPass: ''
                                                    })
                                                }
                                            })
                                        }
                                        value={this.state.password}
                                    />

                                </View>
                                <View
                                    style={{
                                        justifyContent: 'center',
                                        marginTop: 10,
                                        height: 15
                                    }}
                                >
                                    <Text
                                        style={{
                                            color: firebrick,
                                            fontSize: 12
                                        }}
                                    >
                                        {this.state.errorPass}
                                    </Text>
                                </View>

                                <TouchableOpacity
                                    onPress={this.handleLogin}
                                    style={
                                        this.state.errorEmail === '' &&
                                        this.state.errorPass === ''
                                            ? {
                                                alignItems: 'center',
                                                backgroundColor: mediumseagreen,
                                                marginTop: 30,
                                                height: 40,
                                                justifyContent: 'center',
                                                borderRadius: 100
                                            }
                                            : {
                                                alignItems: 'center',
                                                backgroundColor: lightgray,
                                                marginTop: 30,
                                                height: 40,
                                                justifyContent: 'center',
                                                borderRadius: 100
                                            }
                                    }
                                    disabled={
                                        !(this.state.errorEmail === '' &&
                                            this.state.errorPass === '')
                                    }
                                >
                                    <Text
                                        style={{
                                            fontSize: 16,
                                            color: white,
                                            fontWeight: 'bold'
                                        }}
                                    >
                                        登录
                                    </Text>
                                </TouchableOpacity>
                            </View>
                            <TouchableOpacity
                                style={{
                                    alignItems: 'center',
                                    backgroundColor: firebrick,
                                    marginTop: 40,
                                    height: 40,
                                    justifyContent: 'center',
                                    borderRadius: 100
                                }}>
                                <Text
                                    style={{
                                        fontSize: 16,
                                        color: white,
                                        fontWeight: 'bold'
                                    }}>
                                    退出
                                </Text>
                            </TouchableOpacity>
                            <TouchableOpacity
                                style={{
                                    alignItems: 'center',
                                    justifyContent: 'center',
                                    marginTop: 20,
                                    marginBottom: 40
                                }}
                                onPress={this.handleClose}
                            >
                                <Text
                                    style={{ color: royalblue, fontSize: 12 }}
                                >
                                    没有账号去注册？
                                </Text>
                            </TouchableOpacity>
                        </View>
                    </ScrollView>
                </View>

            </Modal>
        )
    }
}
export default UserLogin