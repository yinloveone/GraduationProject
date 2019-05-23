import React, { Component } from 'react';
import {
    Button,
    Dimensions,
    Image,
    PixelRatio,
    StatusBar,
    StyleSheet,
    Text,
    TouchableOpacity,
    View
} from 'react-native';
const width=Dimensions.get('window').width;
import Global from '../utils/Global';
import AntDesign from 'react-native-vector-icons/AntDesign';
export default class CommonTitleBar extends Component {
    render() {
        return (
            <View style={styles.container}>
                <StatusBar
                    backgroundColor='#393A3E'
                    barStyle="light-content"
                />
                <View style={styles.content}>
                    <TouchableOpacity activeOpacity={0.5}  onPress={this.handleBackClick}>
                       <AntDesign name='left' size={16}  style={styles.backBtn}/>
                    </TouchableOpacity>
                    <View style={styles.titleContainer}>
                        <Text style={styles.title}>{this.props.title}</Text>
                    </View>
                </View>
            </View>
        )

    }

    handleBackClick = () => {
        this.props.nav.goBack();
    }
}

const styles = StyleSheet.create({
    container: {
        flexDirection: 'column',
    },
    content: {
        width: width,
        height: 40,
        backgroundColor: Global.titleBackgroundColor,
        flexDirection: 'row',
        alignItems: 'center'
    },
    backBtn: {
        marginLeft: 8,
        marginRight: 8,
        color: '#FFFFFF'
      /*  width: 30,
        height: 30,*/
    },
    titleContainer: {
        flex: 1,
        flexDirection: 'row',
        alignItems: 'center',
        paddingRight: 10,
    },
    title: {
        color: '#FFFFFF',
        fontSize: 16,
        flex: 1,
    },
});