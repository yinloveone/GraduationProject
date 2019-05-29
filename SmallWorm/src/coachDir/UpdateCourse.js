import React,{ Component } from 'react'
import {
    Body, Button, Container, Content, Header, Icon, Left, Form, Text, Title,
    Label, Input, Right, Subtitle, Item, Picker, StyleProvider

} from "native-base";
import {Row,Col} from 'react-native-easy-grid'
import DatePicker from 'react-native-datepicker'
import HttpUtil from "../utils/HttpUtil";
import {StyleSheet, ToastAndroid} from "react-native"
import getTheme from "../../native-base-theme/components";
import material from "../../native-base-theme/variables/material";

export default class UpdateCourse extends Component{
    constructor(props){
        super(props)
        let courseId = this.props.navigation.state.params.courseId;
        this.state = {
            courseId:courseId,
            courseInfo:'',
            courseName:'',
            errorCourseName:'',
            roomName:'',
            errorRoomName:'',
            courseTimeStart:'',
            errorTimeStart:'',
            courseTimeEnd:'',
            errorTimeEnd:'',
            courseTimeCount:1
        }
    }
    componentDidMount(): void {
        this.getCourseInfo();
    }
    getCourseInfo=()=>{
        const url="http://47.100.239.1:8080/api/course/getCourse/"+this.state.courseId
        HttpUtil.get(url).then(result=>{
            if(result.code===0){
                this.setState({
                    courseInfo:result.data,
                    courseName:result.data.courseName,
                    roomName:result.data.roomId,
                    courseTimeEnd:result.data.courseTimeEnd
                })
            }else {
                ToastAndroid.show(result.msg,ToastAndroid.SHORT);
            }
        }).catch(error=>{
            console.log(error)
        })
    }
    onValueChange2(value: string) {
        this.setState({
            roomName: value
        });
    }
    onValueChange(value) {
        this.setState({
            courseTimeCount: value
        });
    }
    updateCourse=()=>{
        const url="http://47.100.239.1:8080/api/course/updatePrivateCourse"
        let theTime=new Date(this.state.courseTimeStart).getTime();
        let endTime = theTime + (this.state.courseTimeCount*45*60*1000)
        let end=new Date(endTime);
        const course={
            courseId:this.state.courseId,
            courseName:this.state.courseName,
            roomId:this.state.roomName,
            courseTimeStart:theTime,
            courseTimeEnd:end,
            courseCapacity:1,
            courseSurplus:1,
            courseType:2
        }
        HttpUtil.post(url,course).then(result=>{
            if(result.code===0){
                ToastAndroid.show(result.msg,ToastAndroid.SHORT);
                this.props.navigation.goBack();
                this.props.navigation.state.params.refresh();
            }else{
                ToastAndroid.show(result.msg,ToastAndroid.SHORT);
            }
        }).catch(error=>{
            console.log(error)
        })
    }

    render(){
        if(!this.state.courseInfo){
            return(
                <StyleProvider style={getTheme(material)}>
                <Container>
                    <Header>
                        <Left>
                            <Button transparent>
                                <Icon name='arrow-back' onPress={() => this.props.navigation.goBack()}/>
                            </Button>
                        </Left>
                        <Body>
                            <Title>课程管理</Title>
                            <Subtitle>编辑课程</Subtitle>
                        </Body>
                    </Header>
                    <Content>
                        <Text>没有课程</Text>
                    </Content>
                </Container>
                </StyleProvider>
            )
        }else{
            return (
                <StyleProvider style={getTheme(material)}>
                <Container>
                    <Header>
                        <Left>
                            <Button transparent>
                                <Icon name='arrow-back' onPress={() => this.props.navigation.goBack()}/>
                            </Button>
                        </Left>
                        <Body>
                            <Title>课程管理</Title>
                            <Subtitle>编辑课程</Subtitle>
                        </Body>
                        <Right>
                            <Button transparent onPress={this.updateCourse}>
                                <Text>
                                    提交
                                </Text>
                            </Button>
                        </Right>
                    </Header>
                    <Content padder>
                        <Form>
                            <Row style={styles.touchableOp}>
                                <Col style={styles.touchablePre}>

                                    <Label>课程名称:</Label>
                                </Col>
                                <Col style={styles.touchableNext}>
                                    <Item regular>
                                        <Input  onChangeText={courseName =>
                                            this.setState({ courseName }, () => {
                                                if (this.state.courseName === '') {
                                                    this.setState({
                                                        errorCourseName: '请输入课程名称'
                                                    })
                                                } else if (this.state.courseName !== '') {
                                                    this.setState({
                                                        errorCourseName: ''
                                                    })
                                                }
                                            })
                                        } value={this.state.courseName}/>
                                    </Item>
                                </Col>
                            </Row>
                            <Row style={{width:'100%'}}>
                                <Text style={{ color: 'red', fontSize: 12 }}>{this.state.errorCourseName}</Text>
                            </Row>
                            <Row style={styles.touchableOp}>
                                <Col style={styles.touchablePre}>

                                    <Label>教室:</Label>
                                </Col>
                                <Col style={styles.touchableNext}>
                                    <Item regular>
                                        <Picker
                                            mode="dropdown"
                                            iosIcon={<Icon name="arrow-down" />}
                                            style={{ width: undefined }}
                                            placeholder="请选择教室"
                                            placeholderStyle={{ color: "#bfc6ea" }}
                                            placeholderIconColor="#007aff"
                                            selectedValue={this.state.roomName}
                                            onValueChange={this.onValueChange2.bind(this)}>
                                            <Picker.Item label="A404" value="1" />
                                            <Picker.Item label="A403" value="2" />
                                            <Picker.Item label="A402" value="3" />
                                            <Picker.Item label="A401" value="4" />
                                        </Picker>
                                    </Item>
                                </Col>
                            </Row>
                            <Row style={styles.touchableOp}>
                                <Col style={styles.touchablePre}>

                                    <Label>上课时间:</Label>
                                </Col>
                                <Col style={styles.touchableNext}>
                                    <DatePicker
                                        style={{width: '100%'}}
                                        date={this.state.courseTimeStart}
                                        mode="datetime"
                                        maximumDate={new Date()}
                                        format="YYYY-MM-DD HH:mm"
                                        confirmBtnText="确定"
                                        cancelBtnText="取消"
                                        showIcon={false}
                                        onDateChange={(courseTimeStart) =>  this.setState({courseTimeStart}, () => {
                                            if (this.state.courseTimeStart === '') {
                                                this.setState({
                                                    errorTimeStart: '请输入上课时间'
                                                })
                                            } else if (this.state.courseTimeStart !== '') {
                                                this.setState({
                                                    errorTimeStart: ''
                                                })
                                            }
                                        })}
                                    />
                                </Col>
                            </Row>
                            <Row style={{width:'100%'}}>
                                <Text style={{ color: 'red', fontSize: 12 }}>{this.state.errorTimeStart}</Text>
                            </Row>
                            <Row style={styles.touchableOp}>
                                <Col style={styles.touchablePre}>
                                    <Label>课程时长:</Label>
                                </Col>
                                <Col style={styles.touchableNext}>
                                    <Item regular>
                                        <Picker
                                            mode="dropdown"
                                            iosIcon={<Icon name="arrow-down" />}
                                            style={{ width: undefined }}
                                            placeholder="请选择教室"
                                            placeholderStyle={{ color: "#bfc6ea" }}
                                            placeholderIconColor="#007aff"
                                            selectedValue={this.state.courseTimeCount}
                                            onValueChange={this.onValueChange.bind(this)}>
                                            <Picker.Item label="45分钟" value="1" />
                                            <Picker.Item label="90分钟" value="2" />
                                        </Picker>
                                    </Item>
                                </Col>
                            </Row>
                        </Form>
                    </Content>
                </Container>
                </StyleProvider>
            )
        }
    }
}
const styles = StyleSheet.create({
    touchableOp: {
        alignItems: 'center',
        justifyContent: 'center',
        marginTop: 20,
    },
    touchablePre: {
        alignItems: 'center',
        justifyContent: 'center',
        width:'30%'
    },
    touchableNext: {
        alignItems: 'center',
        justifyContent: 'center',
        width:'60%'
    }
})