import React,{ Component } from 'react'
import {Body, Button, Container, Content, Header, Icon, Left, Form, Text, Title,
     Label,Input,Right,Subtitle,Item, Picker,DatePicker

} from "native-base";
import {Grid,Row,Col} from 'react-native-easy-grid'
import {Dimensions, StyleSheet} from "react-native";
const DeviceWidth = Dimensions.get('window').width
export default class AddCourse extends Component{
    constructor(props){
        super(props)
        this.state = {
            courseName:'',
            errorCourseName:'',
            roomName:'',
            errorRoomName:'',
            courseTimeStart:'',
            errorTimeStart:'',
            courseTimeEnd:'',
            errorTimeEnd:''
        }
        this.setDate = this.setDate.bind(this);
    }
    onValueChange2(value: string) {
        this.setState({
            roomName: value
        });
    }
    setDate(newDate) {
        this.setState({ courseTimeStart: newDate });
    }
    handleChange = ()=>{
        if (this.state.courseName === '') {
            this.setState({
                errorCourseName: '请输入课程名称'
            })
        } else if (this.state.courseName !== '') {
            this.setState({
                errorCourseName: ''
            })
        }
    }
    render(){
        return(
            <Container>
                <Header>
                    <Left>
                        <Button transparent>
                            <Icon name='arrow-back' onPress={() => this.props.navigation.goBack()}/>
                        </Button>
                    </Left>
                    <Body>
                        <Title>课程管理</Title>
                        <Subtitle>添加课程</Subtitle>
                    </Body>
                    <Right>
                        <Button transparent>
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
                        <Item rounded>
                            <Input  />
                        </Item>
                            </Col>
                        </Row>
                        <Row style={{width:'100%',marginBottom:20}}>
                            <Text style={{ color: 'red', fontSize: 12 }}>{this.state.errorCourseName}</Text>
                        </Row>
                        <Row style={styles.touchableOp}>
                            <Col style={styles.touchablePre}>

                                <Label>教室:</Label>
                            </Col>
                            <Col style={styles.touchableNext}>
                                <Item rounded>
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
                                <Item rounded>

                                    <DatePicker
                                        defaultDate={new Date()}
                                        locale={"en"}
                                        timeZoneOffsetInMinutes={undefined}
                                        modalTransparent={false}
                                        animationType={"fade"}
                                        androidMode={"default"}
                                        placeHolderText="Select date"
                                        textStyle={{ color: "green" }}
                                        placeHolderTextStyle={{ color: "#d3d3d3" }}
                                        onDateChange={this.setDate}
                                        disabled={false}
                                    />
                                </Item>
                            </Col>
                        </Row>
                        <Row style={styles.touchableOp}>
                            <Col style={styles.touchablePre}>
                                <Label>下课时间:</Label>
                            </Col>
                            <Col style={styles.touchableNext}>
                                <Item rounded>
                                    <Input />
                                </Item>
                            </Col>
                        </Row>

                    </Form>
                </Content>
            </Container>
        )
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