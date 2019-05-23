import React,{ Component } from 'react';
import {
    View,
    StyleSheet,
    Text,
    Modal,
    TouchableOpacity,
    Dimensions,
    Image,
    FlatList,
} from 'react-native';
import moment from 'moment';
const {width,height} =Dimensions.get('window')
var toYear = (moment(new Date()).format('YYYY'))
var toMonth = (moment(new Date()).format('MM'))

export default class RNCalendar_CL extends Component {
    constructor(props){
        super(props)
        this.state = {
            modalVisible:false,
            selectedDate:'',
            dayData: [],
            month: toMonth,
            year: toYear,
            color:[],
        }
    }

    showModal(){
      //  LogUtil.log('calender:'+this.props.defaultDate);
        this.setState({modalVisible:true})
    }

    cancelModal(){
        this.setState({modalVisible:false})
    }

    dateChanged(date){
        this.setState({modalVisible:false});
        this.props.dateChanged(date);
    }

// ==============================日历相关======================================

    componentDidMount() {
        var dayCount = this.getDaysOfMonth(toYear, toMonth)
        var dayIn = this.getFirstDay(toYear, toMonth)
        var temp = []
        var color = []
        for (var i = 1; i < dayIn; i++) {
            temp.push(' ')
            color.push(0)
        }
        for (var i = 1; i <= dayCount; i++) {
            temp.push(i)
            color.push(0)
        }
        this.setState({
            dayData: temp,
            color:color,
        })

    }



    createHeaderBar = () =>{
        return(
            <View style={{
                height: 50,
                width: width,
                backgroundColor: '#FFFFFF',
                flexDirection: 'row',
                justifyContent: 'space-between',
                alignItems: 'center'
            }}>
                <TouchableOpacity
                    activeOpacity={1}
                    style={{marginLeft: 10}}
                    onPress={this.clickPrevious}>
                    {/*<Image*/}
                    {/*style={{*/}
                    {/*height: 30,*/}
                    {/*width: 30*/}
                    {/*}}*/}
                    {/*source={require('../../../resource/images/waitTransferOwner/add.png')}*/}
                    {/*resizeMode={'contain'}/>*/}
                    <Text style={{fontSize:14,
                        color:'#9EA3AD',
                    }}>上个月</Text>
                </TouchableOpacity>
                <Text style={{
                    fontSize: 16,
                    color:'#243047'
                }}>
                    {this.state.year + '年' + this.state.month + '月'}
                </Text>
                <TouchableOpacity
                    activeOpacity={1}
                    style={{marginRight: 10}}
                    onPress={this.clickNext}>
                    {/*<Image*/}
                    {/*style={{*/}
                    {/*height: 30,*/}
                    {/*width: 30*/}
                    {/*}}*/}
                    {/*source={require('../../../resource/images/waitTransferOwner/add.png')}*/}
                    {/*resizeMode={'contain'}/>*/}
                    <Text style={{fontSize:14,
                        color:'#9EA3AD',
                    }}>下个月</Text>
                </TouchableOpacity>
            </View>
        )
    }

    createDayBar = () =>{
        return(
            <View style={{
                height: 40,
                width: width,
                alignItems: 'center',
                flexDirection: 'row',
            }}>
                {this.createLab()}
            </View>
        )
    }

    createLab = () => {
        var dateArray = ['一', '二', '三', '四', '五', '六', '七']
        var array = []
        for (var i = 1; i < 8; i++) {
            array.push(
                <View
                    key={I}
                    style={{
                        width: width / 7,
                        height: 40,
                        justifyContent: 'center',
                        alignItems: 'center',
                        backgroundColor: '#FFFFFF'
                    }}>
                    <Text style={{
                        color: '#243047',
                        fontSize: 16
                    }}>
                        {dateArray[i - 1]}
                    </Text>
                </View>
            )
        }
        return array
    }
    creatContent = () =>{
        return(
            <FlatList
                data={this.state.dayData}
                numColumns={7}
                horizontal={false}
                extraData={this.state}
                renderItem={this.renderItem}
                keyExtractor={this.keyExtractor}/>
        )
    }
    clickItem = (item, index) => {
        if (item == ' ') {
            return
        }
        var temp = this.state.color
        if (temp[index] == 1) {
            temp[index] = 0
        }
        else if (temp[index] == 0) {
            temp[index] = 1
        }
        this.setState({
            selectedDate:(toYear+'-'+toMonth+'-'+item),
            color:temp
        },()=>{
          //  LogUtil.log('我选择的日期是'+this.state.selectedDate);
            this.dateChanged(this.state.selectedDate)
        })

    }



    renderItem = ({item,index}) => {
        return (
            <TouchableOpacity
                activeOpacity={1}
                onPress={this.clickItem.bind(this, item, index)}>
                <View
                    style={{
                        width: width / 7,
                        height: 40,
                        justifyContent: 'center',
                        alignItems: 'center',
                        borderRadius: 5,  //圆角5
                        borderWidth: 1,
                        borderColor:'white',
                        backgroundColor:(toYear+'-'+toMonth+'-'+item)===this.state.selectedDate ? '#3576F0' : 'white',

                    }}>
                    <Text
                        style={{color: (toYear+'-'+toMonth+'-'+item)===this.state.selectedDate ? 'white' : '#243047'}}>{item}</Text>
                </View>
            </TouchableOpacity>
        )
    }

    keyExtractor = (item, index) => 'Zdate' + index

    getDaysOfMonth = (year, month) => {
        var day = new Date(year, month, 0)
        var dayCount = day.getDate()
        return dayCount
    }

    getFirstDay = (year, month) => {
        var day = new Date(year, month - 1)
        var dayCount = day.getDay()
        if (dayCount == 0) {
            dayCount = 7
        }
        return dayCount
    }
    clickNext = () => {
        toMonth++
        if (toMonth > 12) {
            toMonth = 1
            toYear++
        }
        this.setState({
            month: toMonth,
            year: toYear
        })

        var dayCount = this.getDaysOfMonth(toYear, toMonth)
        var dayIn = this.getFirstDay(toYear, toMonth)
        var temp = []
        var color = []
        for (var i = 1; i < dayIn; i++) {
            temp.push(' ')
            color.push(0)
        }
        for (var i = 1; i <= dayCount; i++) {
            temp.push(i)
            color.push(0)
        }
        this.setState({
            dayData: temp,
            color:color,
        })
    }

    clickPrevious = () => {
        toMonth--
        if (toMonth < 1) {
            toMonth = 12
            toYear--
        }
        this.setState({
            month: toMonth,
            year: toYear
        })
        var dayCount = this.getDaysOfMonth(toYear, toMonth)
        var dayIn = this.getFirstDay(toYear, toMonth)
        var temp = []
        for (var i = 1; i < dayIn; i++) {
            temp.push(' ')
        }
        for (var i = 1; i <= dayCount; i++) {
            temp.push(i)
        }
        this.setState({
            dayData: temp
        })
    }
    render(){
        return <Modal animationType="fade"  //slide
                      visible={this.state.modalVisible}
                      transparent={true}
                      onRequestClose={()=>this.setState({modalVisible:false})}
        >
            <View style={styles.modalStyle}>
                <View style={styles.subView}>
                    <View style={styles.canlendarStyle}>
                        {this.createHeaderBar()}
                        <View style={{
                            width: '100%',
                            height: 0.5,
                            alignSelf: 'center',
                            borderBottomWidth: 1,
                            borderBottomColor: '#dddddd',
                        }}/>
                        {this.createDayBar()}
                        {this.creatContent()}


                    </View>

                    {/*取消按钮*/}
                    <TouchableOpacity
                        style={[styles.actionItemTitle,this.props.itemStyle,{borderTopWidth:0,height:50,marginBottom:-5}]}
                        onPress={()=>this.setState({modalVisible:false})}>
                        <Text style={styles.actionItemTitle}>取消</Text>
                    </TouchableOpacity>
                </View>
            </View>
        </Modal>
    }

}
const styles = StyleSheet.create({
    modalStyle:{
        justifyContent:'flex-end',
        alignItems:'center',
        flex:1,
        backgroundColor:'rgba(0,0,0,0.2)'
    },
    subView:{
        justifyContent:'flex-end',
        flexDirection: 'column',
        alignItems:'center',
        alignSelf:'stretch',
        width:width,
        backgroundColor:'#fff'

    },
    canlendarStyle:{
        width:width,
        height:320,
        alignItems:'center',
        justifyContent:'center',
        borderTopColor:'#cccccc',
        borderTopWidth:0.5,
        backgroundColor: 'white',
    },
    actionItemTitle:{
        fontSize:18,
        color:'blue',
        textAlign:'center',
    },

})
