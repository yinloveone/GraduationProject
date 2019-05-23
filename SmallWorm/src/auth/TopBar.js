import React, { Component } from 'react'
import { View, Text } from 'react-native'
import { seagreen, white } from 'color-disk'


export default class TopBar extends Component {
    render() {
        return (
            <View
                style={{
                    height: 88,
                    backgroundColor: seagreen,
                    alignItems: 'center',
                    justifyContent: 'center'
                }}>
                <Text style={{ fontSize: 20, color: white, fontWeight: 'bold', marginTop: 10 }}>
                    {this.props.title}
                </Text>
            </View>
        )
    }
}