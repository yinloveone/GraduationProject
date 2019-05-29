import React, { Component } from 'react';
import {
    Container,
    Header,
    Right,
    Left,
    Body,
    Content,
    Button, Icon, Title, Text, Card, CardItem, StyleProvider
} from "native-base";
import {ToastAndroid} from "react-native";
import StorageUtil from "../utils/StorageUtil";
import getTheme from "../../native-base-theme/components";
import material from "../../native-base-theme/variables/material";
/*const datas = [
    {
        hourName: "产后恢复",
        coachName: "丽丽",
        hourCount:20
    },
]*/
/*var datas;*/


export default class CourseHour extends Component{
    constructor(props){
        super(props);
        this.state ={
            datas: null,
            stuId:'',
        };

    }
  componentDidMount(){
        const stuId=1;
        StorageUtil.get('stuId', (error, object) => {
          if (!error && object && object.stuId) {
            //  this.setState({stuId: object.stuId});
              const url = 'http://47.100.239.1:8080/api/user/getCourseHour/'+object.stuId;
              fetch(url).then(response => response.json())
                  .then((json)=>{
                      if (json.code === 0){
                       //   ToastAndroid.show('请求成功',ToastAndroid.SHORT);
                          this.setState({
                              datas:json.data,
                          })
                      }else{
                          ToastAndroid.show(json.msg,ToastAndroid.SHORT);

                      }
                  }) .catch((e) => {
                      console.log(e);
                  })


          }
      });

    }
    cardItemList(){
        let resultList = [];
        let list=this.state.datas;
        for(let i=0;i<list.length;i++){
            resultList.push(
                <Card key={list[i].hourId}>
                <CardItem>
                <Body>
                    <Text style={{fontSize:18}}>{list[i].hourName}</Text>
                    <Text>教练:{list[i].coachName}</Text>
                    <Text>课时剩余:{list[i].hourCount}</Text>
                    <Text>有效期限:无限</Text>
                </Body>
            </CardItem>
                </Card>)

        }
        return resultList;
    }


    render(){
        if(!this.state.datas){
            return(
                <StyleProvider style={getTheme(material)}>
                <Container>
                    <Header>
                        <Left>
                            <Button transparent onPress={() => this.props.navigation.goBack()}>
                                <Icon name="arrow-back"/>
                            </Button>
                        </Left>
                        <Body>
                            <Title>我的课时</Title>
                        </Body>
                        <Right/>
                    </Header>
                    <Content>
                <Text>loading...</Text>
                    </Content>
                </Container>
                </StyleProvider>
            );
        }else {
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
                            <Title>我的课时</Title>
                        </Body>
                        <Right/>
                    </Header>
                    <Content>
                            {
                                this.cardItemList()
                            }
                    </Content>
                </Container>
                </StyleProvider>
            )
        }
    }
}