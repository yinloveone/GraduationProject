import React,{ Component } from 'react';

import{
    View,
    ScrollView,
    TextInput,
    Dimensions,
    Text,
    StyleSheet,
    TouchableOpacity,
    ToastAndroid,
}from 'react-native';

import {
    white,
    seagreen,
    mediumseagreen,
    firebrick,
    lightgray
} from 'color-disk';
import Icon from "react-native-vector-icons/Ionicons";

import StorageUtil from '../utils/StorageUtil'
const DeviceWidth = Dimensions.get('window').width
import TabBar from "./TopBar";

export default class UserRegister extends Component{
    constructor(props){
        super(props);
        this.state = {
            email: '',
            name: '',
            password: '',
            comPassword: '',
            errorEmail: '',
            errorName: '',
            errorPass: '',
            errorComPass: '',
            loginModalVisible: false
        }
    }
    handleChange = ()=>{
        if(this.state.email === ''){
            this.setState({
                errorEmail: '请输入邮箱'
            })
        }else if(this.state.email !== ''){
            this.setState({
                errorEmail: ''
            })
        }
        if(this.state.name === ''){
            this.setState({
                errorName: '请输入用户名'
            })
        }else if(this.state.name !== ''){
            this.setState({
                errorName: ''
            })
        }
        if (this.state.password === '') {
            this.setState({
                errorPass: '请输入密码, '
            })
        } else if (this.state.password !== '') {
            this.setState({
                errorPass: ''
            })
        }
        if (this.state.comPassword === '') {
            this.setState({
                errorComPass: '请确认密码'
            })
        } else if (this.state.comPassword !== '') {
            this.setState({
                errorComPass: ''
            })
        }

    }

    handleRegister = () =>{
        const newUser = {
            email: this.state.email,
            name: this.state.name,
            password: this.state.password,
        }
        const url = 'http://192.168.43.4:8080/register';

        const opts = {
            method: "POST",
            mode: "cors",
            headers: {
                "Content-Type": "application/json"
            },
            body: JSON.stringify(newUser)
        };
        fetch(url,opts).then(response => response.json()).then((json)=>{
            if (json.status === 0){
                ToastAndroid.show('注册成功',ToastAndroid.SHORT);
                StorageUtil.set('username',{'username':this.state.name});
                this.handleOpenLogin;
            }else if(json.status === 2) {
                ToastAndroid.show('用户名被占用',ToastAndroid.SHORT);
            }else{
                ToastAndroid.show('注册失败'+json.status,ToastAndroid.SHORT);

            }
        }) .catch((e) => {
            console.log(e);
        })

    }

    handleClose = () => {
        this.setState({
            loginModalVisible: false
        })
    }
    handleOpenLogin = () => {
        //navigationUtil.reset(this.props.navigation, 'UserLogin');
    }
    render(){
        return(
            <View>
                <TabBar title="注册"/>
                <ScrollView
                    contentContainerStyle={{
                        paddingTop:DeviceWidth * 0.05,
                        paddingLeft:DeviceWidth * 0.05,
                        paddingRight:DeviceWidth * 0.05
                    }}>
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
                                            errorEmail: '请输入邮箱, '
                                        })
                                    } else if (this.state.email !== '') {
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
                        <Text style={{ color: firebrick, fontSize: 12 }}>{this.state.errorEmail}</Text>
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
                        <Icon name="ios-contact" size={20} color={seagreen} style={{ marginLeft: 10 }}/>
                        <TextInput
                            style={{
                                height: 40,
                                fontSize: 16,
                                marginLeft: 4,
                                flex: 1
                            }}
                            placeholder="输入用户名"
                            onChangeText={name =>
                                this.setState({ name }, () => {
                                    if (this.state.name === '') {
                                        this.setState({
                                            errorName: '请输入用户名, '
                                        })
                                    } else if (this.state.name !== '') {
                                        this.setState({
                                            errorName: ''
                                        })
                                    }
                                })
                            }
                            onChange={this.handleChange}
                            value={this.state.name}
                        />
                    </View>
                    <View
                        style={{
                            justifyContent: 'center',
                            marginTop: 10,
                            height: 15
                        }}
                    >
                        <Text style={{ color: firebrick, fontSize: 12 }}>{this.state.errorName}</Text>
                    </View>
                    <View
                        style={{
                            marginTop: 15,
                            borderColor: seagreen,
                            borderWidth: 1,
                            borderRadius: 100,
                            flexDirection: 'row',
                            alignItems: 'center'
                        }}>
                        <Icon name="ios-unlock" size={20} color={seagreen} style={{ marginLeft: 10 }}/>
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
                                    if (this.state.password === '') {
                                        this.setState({
                                            errorPass: '请输入密码, '
                                        })
                                    } else if (this.state.password !== '') {
                                        this.setState({
                                            errorPass: ''
                                        })
                                    }
                                    if (this.state.password2 !== this.state.password) {
                                        this.setState({
                                            errorPass2: '密码不一致'
                                        })
                                    } else if (this.state.password2 === this.state.password) {
                                        this.setState({
                                            errorPass2: ''
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
                        <Text style={{ color: firebrick, fontSize: 12 }}>{this.state.errorPass}</Text>
                    </View>
                    <View
                        style={{
                            marginTop: 15,
                            borderColor: seagreen,
                            borderWidth: 1,
                            borderRadius: 100,
                            flexDirection: 'row',
                            alignItems: 'center'
                        }}>
                        <Icon name="ios-lock" size={20} color={seagreen} style={{ marginLeft: 10 }}/>
                        <TextInput
                            style={{
                                height: 40,
                                fontSize: 16,
                                marginLeft: 4,
                                flex: 1
                            }}
                            secureTextEntry={true}
                            placeholder="确认密码"
                            onChangeText={password2 =>
                                this.setState({ password2 }, () => {
                                    if (this.state.password2 !== this.state.password) {
                                        this.setState({
                                            errorPass2: '密码不一致'
                                        })
                                    } else if (this.state.password2 === this.state.password) {
                                        this.setState({
                                            errorPass2: ''
                                        })
                                    }
                                })
                            }
                            onChange={this.handleChange}
                            value={this.state.password2}
                        />
                    </View>
                    <View
                        style={{
                            justifyContent: 'center',
                            marginTop: 10,
                            height: 15
                        }}
                    >
                        <Text style={{ color: firebrick, fontSize: 12 }}>{this.state.errorPass2}</Text>
                    </View>
                    <TouchableOpacity
                        onPress={this.handleRegister}
                        style={
                            this.state.errorEmail !== '' ||
                            this.state.errorName !== '' ||
                            this.state.errorPass !== '' ||
                            this.state.errorPass2 !== ''
                                ? styles.touchablePre : styles.touchableNext
                        }
                        disabled={
                            !(this.state.errorEmail === '' &&
                                this.state.errorName === '' &&
                                this.state.errorPass === '' &&
                                this.state.comPassword === '')
                        }
                    >
                        <Text style={{ fontSize: 16, color: white, fontWeight: 'bold' }}>注册</Text>
                    </TouchableOpacity>
                    {/* <TouchableOpacity
                    style={ styles.touchableOp}
                    onPress={this.handleOpenLogin}>
                    <Text style={{ color: royalblue, fontSize: 12 }}>已有账号？登录</Text>
                </TouchableOpacity>*/}

                </ScrollView>
            </View>
        )
    }

}

const styles = StyleSheet.create({
    touchableOp: {
        alignItems: 'center',
        justifyContent: 'center',
        marginTop: 20,
        marginBottom: 40
    },
    touchablePre: {
        alignItems: 'center',
        backgroundColor: lightgray,
        marginTop: DeviceWidth * 0.1,
        height: 40,
        justifyContent: 'center',
        borderRadius: 100
    },
    touchableNext: {
        alignItems: 'center',
        backgroundColor: mediumseagreen,
        marginTop: DeviceWidth * 0.1,
        height: 40,
        justifyContent: 'center',
        borderRadius: 100
    }
})