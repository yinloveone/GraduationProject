import React, { Component } from 'react'
import {
    Container,
    Content,
    List, ListItem,
    Text, Button, Body,
    Right, H1, Header,
    Left, Icon, Title,
    ActionSheet,
    Item,
    Picker,
    Input, DatePicker,
} from 'native-base';
import HttpUtil from "../utils/HttpUtil";
import {ToastAndroid} from "react-native";
import StorageUtil from "../utils/StorageUtil";
import {Grid, Row,Col} from "react-native-easy-grid";
import AntDesign from "react-native-vector-icons/AntDesign";

const BUTTONS = ["时间", "教练", "课程"];
/*const DESTRUCTIVE_INDEX = 3;
const CANCEL_INDEX = 4;*/

export default class ProfileScreen extends Component {
    constructor(props){
        super(props);
        this.state = {
            dataList:null,
            selected2: undefined,
            chosenDate: undefined,
            paramCourse:undefined,
        }
    }
    onValueChange2(value: string) {
        this.setState({
            selected2: value
        });
    }
    setDate(newDate) {
        this.setState({ chosenDate: newDate });
        const course={
            courseTimeStart:newDate
        }
        const url = 'http://47.100.239.1:8080/api/user/getCourse';
        HttpUtil.post(url,course).then(result=>{
            if(result.code===0){
                this.setState({
                    dataList: result.data
                })
            }else{
                this.setState({
                    dataList: null
                })
            }
            console.log(result)
        }).catch(error => {
            console.log(error)
        })
    }
    componentDidMount(){
       this.getCourse();
    }

    getCourse = () =>{
        let nextDate = new Date(new Date().getTime() + 2*24*60*60*1000);
        const url = 'http://47.100.239.1:8080/api/user/getCourse';
        let course;
        if(this.state.selected2 ==='coachName'){
        course = {
            coachName: this.state.paramCourse,
           // courseTimeStart: nextDate,
        }
        }else{
            course = {
                courseName: this.state.paramCourse,
              //  courseTimeStart: nextDate,
            }
        }
        HttpUtil.post(url,course).then(result=>{
            if(result.code===0){
                this.setState({
                   dataList: result.data
                })
            }else{
                this.setState({
                    dataList: null
                })
            }
            console.log(result)
        }).catch(error => {
            console.log(error)
        })

    }
    orderCourse(courseId,e){
        let stuId;
        StorageUtil.get('stuId', (error, object) => {
            if (!error && object && object.stuId) {
                stuId = object.stuId;

        const courseRecord = {
            stuId: object.stuId,
            courseId: courseId
        }
        const url = 'http://47.100.239.1:8080/api/user/orderCourse';
        HttpUtil.post(url,courseRecord).then(result=>{
            if(result.code===0){
                ToastAndroid.show(result.msg,ToastAndroid.SHORT);
                this.getCourse();
            }else{
                ToastAndroid.show(result.msg,ToastAndroid.SHORT);
            }
        }) .catch(error => {
            console.log(error);
        })
            }
        });
    }
    render() {
            return (
                <Container>
                    <Header>
                        <Left>
                            <Button transparent onPress={() => this.props.navigation.goBack()}>
                                <Icon name="arrow-back"/>
                            </Button>
                        </Left>
                        <Body><Title>团体课程</Title></Body>
                         <Right>
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
                        <Grid>
                            <Row style={{marginTop: 5}}>
                                <Col style={{width:'30%'}}>
                                    <Item>
                            <Picker
                                    mode="dropdown"
                                    placeholder="请选择"
                                    placeholderStyle={{ color: "#bfc6ea" }}
                                    placeholderIconColor="#007aff"
                                    selectedValue={this.state.selected2}
                                    onValueChange={this.onValueChange2.bind(this)}
                                >
                                    <Item label="教练" value="coachName" />
                                    <Item label="课程名" value="courseName" />
                                </Picker>
                                    </Item>
                                </Col>
                                <Col style={{width:'70%'}}>

                                    <Item>
                                    <Input placeholder='输入条件'
                                           onChangeText={ paramCourse => this.setState({paramCourse},()=>{

                                           })}
                                           value={this.state.paramCourse}
                                     />
                                        <Button transparent onPress={this.getCourse}>
                                            <Icon name='search'  />
                                        </Button>
                                        </Item>
                                </Col>

                            </Row>
                        </Grid>
                                   { this.state.dataList === null ? <Text>没有数据</Text>:
                                   <List
                                            dataArray={this.state.dataList}
                                            renderRow={data =>
                                                <ListItem thumbnail>
                                                    <H1>{data.timeStartStr}</H1>
                                                    <Body>
                                                        <Text>
                                                            {data.courseName}({data.currDate})
                                                        </Text>
                                                        <Text>
                                                            {data.coachName} {data.roomName}
                                                        </Text>
                                                        <Text>{data.timeEndStr}下课</Text>
                                                        <Text note style={{color:'#0000ff'}}>
                                                            还可预约{data.courseSurplus}人
                                                        </Text>
                                                    </Body>
                                                    <Right>
                                                        <Button success onPress={this.orderCourse.bind(this,data.courseId)}>
                                                            <Text>预约</Text>
                                                        </Button>
                                                    </Right>
                                                </ListItem>}
                                        />
                                   }
                    </Content>
                </Container>
            )

    }
}