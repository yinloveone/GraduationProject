import React,{ Component } from 'react'
import {Body, Button, Container, Content, List,Header, Icon,
    Left, Text, Title,
    ListItem,
    Right
} from "native-base";
import HttpUtil from "../utils/HttpUtil";
export  default class CourseSignIn extends Component{
    constructor(props){
        super(props);
        let courseId = this.props.navigation.state.params.courseId;
       // console.log(courseId)
        this.state={
            courseId:courseId,
            studentList:'',
            currIndex:'',
            show:true
        }
    }
    componentDidMount(): void {

       this.getCourseSelect();
    }
    /*
    * 根据课程id获取选课的情况
    * */
    getCourseSelect = () =>{
        const url = 'http://47.100.239.1:8080/api/courseRecord/getSelectStudent/'+this.state.courseId;
        HttpUtil.get(url).then(result=>{
            if(result.code === 0){
                this.setState({
                    studentList:result.data
                })
            }

        }).catch(error => {
            console.log(error)
        })

    }
    /*
    * 学员签到
    * */
    studentIn=(courseRecordId,e)=>{
        const t=e;
        this.setState({
            currIndex:courseRecordId,
            show:false
        })
  /*      const url = 'http://47.100.239.1:8080/api/courseRecord/getSelectStudent'
        const record = {
            courseRecordId:courseRecordId,
            signIn:0
        }
        HttpUtil.post(url,record).then(result=>{
            if(result.code==0){

            }else{

            }
        }).catch(error => {
            console.log(error)
        })*/

    }

    render(){
        if(this.state.studentList) {
            return (
                <Container>
                    <Header>
                        <Left>
                            <Button transparent>
                                <Icon name='arrow-back' onPress={() => this.props.navigation.goBack()}/>
                            </Button>
                        </Left>
                        <Body>
                            <Title>学员签到</Title>
                        </Body>
                    </Header>
                    <Content padder>
                        <List
                            dataArray={this.state.studentList}
                            renderRow={data =>
                                <ListItem>
                                    <Left>
                                        <Text>
                                            {data.stuName}
                                        </Text>
                                    </Left>
                                    <Right>
                                        {
                                            this.state.currIndex!==data.courseRecordId ?(
                                                <Button onPress={this.studentIn.bind(this, data.courseRecordId)}>
                                                    <Text>
                                                        签到
                                                    </Text>
                                                </Button>
                                            ):(

                                                <Button disabled>
                                                    <Text>签到</Text>
                                                </Button>
                                            )
                                        }
                                    </Right>
                                </ListItem>}
                        />
                    </Content>
                </Container>
            )
        }else{
            return (
                <Container>
                    <Header>
                        <Left>
                            <Button transparent>
                                <Icon name='arrow-back' onPress={() => this.props.navigation.goBack()}/>
                            </Button>
                        </Left>
                        <Body>
                            <Title>学员签到</Title>
                        </Body>
                    </Header>
                    <Content>
                    <Text>Loading</Text>
                    </Content>
                </Container>
            )
        }
    }
}