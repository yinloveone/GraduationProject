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

const DeviceWidth = Dimensions.get('window').width;
export default class UserIndex extends Component{
    render(){
        let avatar = require('../../img/6.png');

        return(
            <View style={styles.container}>
                <View style={styles.divider}/>
                <ScrollView style={styles.content}>
                        <TouchableHighlight underlayColor={Global.touchableHighlightColor} onPress={() => {
                            this.turnOnPage('UserInfo')
                        }}>
                            <View style={styles.meInfoContainer}>
                                <Image style={styles.meInfoAvatar} source={avatar}/>
                                <View style={styles.meInfoContainer}>
                                    <Text style={styles.meInfoNickName}>可摘星辰</Text>
                                </View>
                                <View style={{ position:'absolute',right:5 }}>
                                <AntDesign name="right" size={16} />
                                </View>
                            </View>
                        </TouchableHighlight>
                    <View style={{width: DeviceWidth, height: 20}}/>
                    <ListItem text={"我的课表"} icon={'md-clipboard'} handleClick={() => {
                        this.turnOnPage('CourseScreen')}} />
                    <ListItemDivider/>
                    <ListItem text={"我的课时"} icon={'md-reorder'} handleClick={() => {
                        this.turnOnPage('CourseHour')}}/>
                    <ListItemDivider/>
                    <ListItem text={"体重记录"} icon={'md-wallet'}  handleClick={() => {
                        this.turnOnPage('ClubCard')}}/>
                    <ListItemDivider/>
                    <ListItem text={"会员卡"} icon={'md-wallet'}  handleClick={() => {
                        this.turnOnPage('ClubCard')}}/>
                    <View style={{width: DeviceWidth, height: 20}}/>
                    <ListItem text={"退出登录"} icon={'ios-power'} handleClick={() => {
                        this.logout()}}/>
                </ScrollView>
                <View style={styles.divider}/>
            </View>
        )
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
