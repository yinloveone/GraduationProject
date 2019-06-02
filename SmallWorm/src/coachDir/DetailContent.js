import React,{ Component } from 'react'
import {
    Body, Button, Container, Content, List, Header, Icon,
    Left, Text, Title,
    ListItem,
    Right, StyleProvider,
    Thumbnail
} from "native-base";
import HttpUtil from "../utils/HttpUtil";
import {ToastAndroid} from "react-native";
import getTheme from "../../native-base-theme/components";
import material from "../../native-base-theme/variables/material";
export  default class DetailContent extends Component{
    constructor(props){
        super(props);
        let courseId = this.props.navigation.state.params.courseId;
        // console.log(courseId)
        this.state={
            courseId:courseId,
            contentList:'',
        }
    }
    componentDidMount(): void {
        this.getDetailList();
    }
    getDetailList = ()=>{
        const url = 'http://47.100.239.1:8080/api/courseRecord/getDetailContent/'+this.state.courseId;
        HttpUtil.get(url).then(result=>{
            if(result.code === 0){
                this.setState({
                    contentList:result.data
                })
            }

        }).catch(error => {
            console.log(error)
        })
    }
    renderItems() {
        const dataList = this.state.contentList;
        let replys = [];
        for (let i = 0; i < dataList.length; i++) {
            replys.push(
                <ListItem avatar>
                    <Left>
                        <Thumbnail source={{ uri: '../../img/6.png' }} />
                    </Left>
                    <Body>
                        <Text>{dataList[i].stuName}</Text>
                        <Text note>{dataList[i].content}</Text>
                    </Body>
                    <Right>
                       <Text>分数:{dataList[i].score}</Text>
                    </Right>
                </ListItem>
            )
        }
        return replys;
    }

    render(){
        if(!this.state.contentList){
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
                                <Title>课程评价</Title>
                            </Body>
                        </Header>
                        <Content>
                            <Text>没有评论呢</Text>
                        </Content>
                    </Container>
                </StyleProvider>
            )
        }else{
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
                                <Title>课程评价</Title>
                            </Body>
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