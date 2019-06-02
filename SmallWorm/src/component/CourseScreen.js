import React,{ Component } from 'react';
import {
    Container,
    Header,
    Content,
    List,
    ListItem,
    Text,
    Button,
    Icon,
    Left,
    Body,
    Title,
    Right, StyleProvider, DatePicker
} from 'native-base';
import HttpUtil from '../utils/HttpUtil'
import StorageUtil from "../utils/StorageUtil";
import {ToastAndroid,Alert} from "react-native";
import getTheme from "../../native-base-theme/components";
import material from "../../native-base-theme/variables/material";
import AntDesign from "react-native-vector-icons/AntDesign";
export default  class CourseScreen extends Component{
    constructor(props){
        super(props)
        this.state = {
            dataList:null,
            chosenDate:''
        }
    }
    componentDidMount(){
        this.getCourseOrder()
    }
    setDate(newDate) {
        this.setState({ chosenDate: newDate });
        this.getCourseOrder();
    }

    getCourseOrder(){

        StorageUtil.get('stuId', (error, object) => {
            if (!error && object && object.stuId) {
                const url = 'http://47.100.239.1:8080/api/courseRecord/getRecordById';
                const data={
                    stuId:object.stuId,
                    dateRange:this.state.chosenDate
                }
                HttpUtil.post(url,data).then(result=>{
                    if(result.code === 0){
                        this.setState({
                            dataList:result.data
                        })
                    }

                }).catch(error => {
                    console.log(error)
                })
                    }
                })
    }
    reload=()=>{
        this.setState({
                dateRange: null
            }
        )
        StorageUtil.get('stuId', (error, object) => {
            if (!error && object && object.stuId) {
                const url = 'http://47.100.239.1:8080/api/courseRecord/getRecordById';
                const data={
                    stuId:object.stuId
                }
                HttpUtil.post(url,data).then(result=>{
                    if(result.code === 0){
                        this.setState({
                            dataList:result.data
                        })
                    }

                }).catch(error => {
                    console.log(error)
                })
            }
        })
    }
    cancelCourse(courseId,courseRecordId,courseTimeStart,courseType,e){
        if((courseTimeStart-new Date().getTime())/60*60*1000<24&&courseType==='1'){
            Alert.alert('提醒','将不能退还课时，是否继续?',[
                {text:'取消',onPress:()=>ToastAndroid.show('取消',ToastAndroid.SHORT)},
                {text:'确定',onPress:()=>{
                        const url = 'http://47.100.239.1:8080/api/user/cancelOrder'
                        let stuId = 0;
                        StorageUtil.get('stuId', (error, object) => {
                            if (!error && object && object.stuId) {
                                stuId = object.stuId;

                                const courseRecord = {
                                    courseId: courseId,
                                    stuId: object.stuId,
                                    courseRecordId: courseRecordId
                                }
                                HttpUtil.post(url, courseRecord).then(result => {
                                    if (result.code === 0) {
                                        this.reload(this);
                                    }
                                    ToastAndroid.show(result.msg, ToastAndroid.SHORT);

                                }).catch(error => {
                                    console.log(error)
                                })
                            }
                        });
                    }}
            ])

        }else{
            const url = 'http://47.100.239.1:8080/api/user/cancelOrder'
            let stuId = 0;
            StorageUtil.get('stuId', (error, object) => {
                if (!error && object && object.stuId) {
                    stuId = object.stuId;

                    const courseRecord = {
                        courseId: courseId,
                        stuId: object.stuId,
                        courseRecordId: courseRecordId
                    }
                    HttpUtil.post(url, courseRecord).then(result => {
                        if (result.code === 0) {
                            this.reload(this);
                        }
                        ToastAndroid.show(result.msg, ToastAndroid.SHORT);

                    }).catch(error => {
                        console.log(error)
                    })
                }
            });

        }


    }
    submitScore = (courseRecordId,e) =>{
        this.props.navigation.navigate('SubmitScore',{
            courseRecordId:courseRecordId
        },{
            refresh:()=>{
                this.reload();
            }})
    }

    renderItems() {
        const dataList = this.state.dataList;
        let replys = [];
        for (let i = 0; i < dataList.length; i++) {

            replys.push(<ListItem itemDivider key={dataList[i].yearMonth}>
                <Text>{dataList[i].yearMonth}</Text>
            </ListItem>)
            for (let j = 0; j < dataList[i].listCourse.length; j++) {
                if(dataList[i].listCourse[j].commentTime){
                    replys.push(
                        <ListItem key={dataList[i].listCourse[j].courseId}>
                            <Body>
                                <Text>{dataList[i].listCourse[j].monthDate}</Text>
                                <Text>{dataList[i].listCourse[j].courseName}({dataList[i].listCourse[j].timeStartStr}-{dataList[i].listCourse[j].timeEndStr})</Text>
                                <Text>上课老师:{dataList[i].listCourse[j].coachName}</Text>
                                <Text>教室:{dataList[i].listCourse[j].roomName}</Text>
                            </Body>
                            <Right>
                                <Text>评分:{dataList[i].listCourse[j].score}分</Text>
                            </Right>
                        </ListItem>
                    )

                }else{
                    replys.push(
                        <ListItem key={dataList[i].listCourse[j].courseId}>
                            <Body>
                                <Text>{dataList[i].listCourse[j].monthDate}</Text>
                                <Text>{dataList[i].listCourse[j].courseName}({dataList[i].listCourse[j].timeStartStr}-{dataList[i].listCourse[j].timeEndStr})</Text>
                                <Text>上课老师:{dataList[i].listCourse[j].coachName}</Text>
                                <Text>教室:{dataList[i].listCourse[j].roomName}</Text>
                            </Body>
                            <Right>
                                {
                                    dataList[i].listCourse[j].courseTimeEnd<new Date().getTime()?<Button success onPress={this.submitScore.bind(this,dataList[i].listCourse[j].courseRecordId)}><Text>评分</Text></Button>:
                                        <Button danger onPress={this.cancelCourse.bind(this, dataList[i].listCourse[j].courseId,dataList[i].listCourse[j].courseRecordId,dataList[i].listCourse[j].courseTimeStart,dataList[i].listCourse[j].courseType)}>
                                            <Text>退课</Text>
                                        </Button>
                                }
                            </Right>
                        </ListItem>
                    )
                }

            }
        }
        return replys;
    }

    render() {
        if (!this.state.dataList) {
            return (
                <StyleProvider style={getTheme(material)}>
                <Container>
                    <Header>
                        <Left>
                            <Button transparent onPress={() => this.props.navigation.goBack()}>
                                <Icon name="arrow-back"/>
                            </Button>
                        </Left>
                        <Body>
                            <Title>我的课表</Title>
                        </Body>
                        <Right/>
                    </Header>
                    <Content>
                        <Text>loading...</Text>
                    </Content>
                </Container>
                </StyleProvider>
            )
        } else {
            return (
                <StyleProvider style={getTheme(material)}>
                <Container>
                    <Header>
                        <Left>
                            <Button transparent onPress={() => this.props.navigation.goBack()}>
                                <Icon name="arrow-back"/>
                            </Button>
                        </Left>
                        <Body>
                            <Title>我的课表</Title>
                        </Body>
                        <Right>
                            <Button transparent onPress={this.reload}>
                                <AntDesign name='sync' size={16} style={{color: 'white'}}/>
                            </Button>
                            <Button transparent>
                                <AntDesign name='calendar' size={16} style={{color: 'white'}}/>
                                <DatePicker
                                    defaultDate={new Date()}
                                    minimumDate={new Date(2019,1,1)}
                                    maximumDate={new Date(2019, 12, 31)}
                                    locale={"en"}
                                    timeZoneOffsetInMinutes={undefined}
                                    modalTransparent={false}
                                    animationType={"fade"}
                                    androidMode={"spinner"}
                                    placeHolderText="选择时间"
                                    textStyle={{ color: "white" }}
                                    placeHolderTextStyle={{ color: "white" }}
                                    onDateChange={this.setDate.bind(this)}
                                    disabled={false}
                                />
                            </Button>

                        </Right>
                    </Header>
                    <Content>
                        <List>
                            {this.renderItems()}
                        </List>
                    </Content>
                </Container>
                </StyleProvider>

            )
        }
    }

}
