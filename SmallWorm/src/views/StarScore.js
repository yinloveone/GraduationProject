import React, { Component } from 'react';
import {
    View,
    TouchableOpacity,
    Dimensions
} from 'react-native';
import AntDesign from "react-native-vector-icons/AntDesign";
import {seagreen} from "color-disk";
const {width} = Dimensions.get('window').width;

export default class StarScore extends Component {
    // 构造
    constructor(props) {
        super(props);
        // 初始状态
        this.state = {
            totalScore: 5, // 总分值
            currentScore: 3, // 分值
        };
    }

    render() {
        return (
            <View style={{flexDirection: 'row', width: width, height: 20, marginBottom: 6}}>
                {this._renderBody()}
            </View>
        );
    }

    _renderBody() {
        let images = [];
        for (var i = 1; i <= this.state.totalScore; i++) {
            let currentCount = i;
            images.push(
                <View key={"i" + i}>
                    <TouchableOpacity onPress={(i) => {this._score(currentCount)}}>
                        <AntDesign name="staro" size={20} style={{width: 20, height: 20}}/>
                        {this._renderYellowStart(i)}
                    </TouchableOpacity>
                </View>
            );
        }
        return images;
    }

    _renderYellowStart(count) {
        if (count <= this.state.currentScore) {
            return (
                <AntDesign name="staro" size={20} color={seagreen} style={{width: 20, height: 20, position: 'absolute'}}/>
            );
        }
    }

    _score(i) {
        this.setState({
            currentScore: i
        });
        this.props.selectIndex(i);
    }

}