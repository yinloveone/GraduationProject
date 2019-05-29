import React, { Component } from 'react';
import {
    Text,
    View,
    StyleSheet,
    ScrollView,
    TouchableHighlight,
    Dimensions,
    PixelRatio,
    Image, ToastAndroid

} from 'react-native';
import Global from '../utils/Global';
import ListItem from '../views/ListItem';
import ListItemDivider from '../views/ListItemDivider';
import AntDesign from 'react-native-vector-icons/AntDesign'
import StorageUtil from '../utils/StorageUtil'
import navigationUtil from "../utils/navigationUtil";
import getTheme from "../../native-base-theme/components";
import material from "../../native-base-theme/variables/material";
import {StyleProvider} from "native-base";
const DeviceWidth = Dimensions.get('window').width;


export default class CoachIndex extends Component{
  constructor(props){
        super(props);
        this.state = {
            userName:null,
        }
    }
    componentDidMount(){
        StorageUtil.get('userName', (error, object) => {
            if (!error && object && object.userName) {
                this.setState({
                    userName:object.userName
                })
            }
        })
    }

   /* getUserInfo = () =>{

        StorageUtil.get('stuId', (error, object) => {
            if (!error && object && object.stuId) {
                const url = 'http://47.100.239.1:8080/api/member/getStudent/'+object.stuId;
                //object.stuId;
                HttpUtil.get(url).then(result=>{
                    if(result.code===0){
                        ToastAndroid.show(result.msg,ToastAndroid.SHORT);
                        this.setState({userInfo:result.data})
                        //console.log(result.data)
                    }else{
                        ToastAndroid.show(result.msg,ToastAndroid.SHORT);
                    }

                }) .catch(error => {
                    console.log(error);
                })
            }})
    }*/

    render(){
        let avatar = require('../../img/header.jpg');
        if(!this.state.userName){
            return (
                <View style={styles.container}>
                    <Text>Loading...</Text>
                </View>
            )
        }else {
            return (
                <StyleProvider style={getTheme(material)}>
                <View style={styles.container}>
                    <View style={styles.divider}/>
                    <ScrollView style={styles.content}>
                        <TouchableHighlight underlayColor={Global.touchableHighlightColor} onPress={() => {
                            this.turnOnPage('CoachInfo')
                        }}>
                            <View style={styles.meInfoContainer}>
                                <Image style={styles.meInfoAvatar} source={avatar}/>
                                <View style={styles.meInfoContainer}>
                                    <Text style={styles.meInfoNickName}>{this.state.userName}</Text>
                                </View>
                                <View style={{position: 'absolute', right: 5}}>
                                    <AntDesign name="right" size={16}/>
                                </View>
                            </View>
                        </TouchableHighlight>
                        <View style={{width: DeviceWidth, height: 20}}/>
                        <ListItem text={"我的课表"} icon={'md-clipboard'} handleClick={() => {
                            this.turnOnPage('CoachCourse')
                        }}/>
                        <ListItemDivider/>
                        <ListItem text={"我的学员"} icon={'md-reorder'} handleClick={() => {
                            this.turnOnPage('StudentActivity')
                        }}/>
                        <ListItemDivider/>
                        <View style={{width: DeviceWidth, height: 20}}/>
                        <ListItem text={"退出登录"} icon={'ios-power'} handleClick={() => {
                            this.logout()
                        }}/>
                    </ScrollView>
                    <View style={styles.divider}/>
                </View>
                </StyleProvider>
            )
        }
    }

    turnOnPage(pageName) {
        this.props.navigation.navigate(pageName);

    }
    logout(){
        StorageUtil.set('hasLogin', {'hasLogin': 'FALSE'});
        ToastAndroid.show('注销成功',ToastAndroid.SHORT);
        navigationUtil.reset(this.props.navigation, 'UserLogin');
    }
}

const styles = StyleSheet.create({
    container: {
        flex: 1,
        width: DeviceWidth,
        flexDirection: 'column',
        justifyContent: 'center',
        alignItems: 'center'
    },
    divider: {
        width: DeviceWidth,
        height: 1 / PixelRatio.get(),
        backgroundColor: '#D3D3D3'
    },
    content: {
        flex: 1,
        width: DeviceWidth,
        flexDirection: 'column',
        backgroundColor: Global.pageBackgroundColor,
    },
    tabBarIcon: {
        width: 24,
        height: 24,
    },
    meInfoContainer: {
        width: DeviceWidth,
        flexDirection: 'row',
        alignItems: 'center',
        paddingLeft: 15,
        paddingRight: 15,
        backgroundColor: '#FFFFFF',
        paddingTop: 15,
        paddingBottom: 15,
    },
    meInfoAvatar: {
        width: 60,
        height: 60,
        borderRadius:30,
    },
    meInfoTextContainer: {
        flex: 1,
        paddingLeft: 15,
        paddingRight: 15,
    },
    meInfoNickName: {
        color: '#000000',
        fontSize: 16,
    },
    meInfoWeChatId: {
        color: '#999999',
        fontSize: 14,
        marginTop: 5,
    },
    meInfoQRCode: {
        width: 25,
        height: 25,
    }
});
