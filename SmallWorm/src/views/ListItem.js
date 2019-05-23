import React, { Component } from 'react';
import Global from '../utils/Global';
import {
    Dimensions,
    Image,
    StyleSheet,
    Text,
    TouchableHighlight,
    View
} from 'react-native';
import Icon from "react-native-vector-icons/Ionicons";
import AntDesign from "react-native-vector-icons/AntDesign";
const {DeviceWidth}= Dimensions.get('window').width;
export default class ListItem extends Component{
    render(){
        return(
            <View>
            <TouchableHighlight underlayColor={Global.touchableHighlightColor} onPress={this.props.handleClick}>
                <View style={listItemStyles.container}>
                    <Icon name={this.props.icon} size={20} style={{ marginLeft: 10 }}/>
                    <View style={listItemStyles.menuContainer}>
                        <Text style={listItemStyles.menuText}>{this.props.text}</Text>
                    </View>
                    <View style={{ position:'absolute',right:5 }}>
                        <AntDesign name="right" size={16} />
                    </View>
                </View>
            </TouchableHighlight>
        </View>
        )}

}

const listItemStyles = StyleSheet.create({
    container: {
        flexDirection: 'row',
        backgroundColor: '#FFFFFF',
        alignItems: 'center',
        paddingLeft: 15,
        paddingRight: 15,
        paddingTop: 15,
        paddingBottom: 15,

    },
    icon: {
        width: 30,
        height: 30,
    },
    menuContainer: {
        paddingLeft: 15,
        paddingRight: 15,
    },
    menuText: {
        color: '#000000',
        fontSize: 16,
    }
});
