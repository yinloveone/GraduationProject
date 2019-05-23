import React, { Component } from 'react';
import Global from '../utils/Global'

import{
    View,
    PixelRatio,
    Dimensions
}from 'react-native';

const {DeviceWidth}= Dimensions.get('window').width;

export default class ListItemDivider extends Component{
    render(){
        const height = 1 / PixelRatio.get();
        return(
            <View style={{width :DeviceWidth, height: height,backgroundColor:'#FFFFFF'}}>
           <View style={{
                height: height,
                marginLeft: 50,
                marginRight: 10,
                backgroundColor: Global.dividerColor
            }}/>
          </View>)
    }

}