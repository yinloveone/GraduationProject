import React, { Component } from 'react'
import { StyleSheet,
    View,
    Alert,
    Button,
    TimePickerAndroid,
    Text,
    DatePickerAndroid
} from 'react-native'
export default class HomeScreen extends Component {
    render() {
        return (
            <View style={styles.container}>
                <View style={styles.rowView}>
                <Button
                    title='日期对话框'
                    onPress={() => {
                        DatePickerAndroid.open()
                            .then(({ action, year, month,day }) => {
                                if (action !== TimePickerAndroid.dismissedAction) {
                                    Alert.alert(year + '/' + month+'/'+day);
                                }
                            })
                    }}
                />

                <Button
                    title='时间对话框'
                    onPress={() => {
                        TimePickerAndroid.open()
                            .then(({ action, hour, minute }) => {
                                if (action !== TimePickerAndroid.dismissedAction) {
                                    Alert.alert(hour + ':' + minute);
                                }
                            })
                    }}
                />
                </View>
            </View>
        )
    }
}

const styles = StyleSheet.create({
    container: {
        flex: 1,
    },
    rowView: {
        flexDirection: 'row'
    }

})