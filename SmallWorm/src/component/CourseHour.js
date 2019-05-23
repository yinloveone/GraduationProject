import React, { Component } from 'react';
import {
    Container,
    Header,
    Right,
    Left,
    Body,
    Content,
     Button, Icon, Title,Text,Card, CardItem
} from "native-base";
import {ToastAndroid} from "react-native";
import StorageUtil from "../utils/StorageUtil";
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
                          ToastAndroid.show('请求成功',ToastAndroid.SHORT);
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
                <CardItem header>
                    <Text>{list[i].hourName}</Text>
                </CardItem>
            )
            resultList.push(
                <CardItem>
                <Body>
                    <Text>{list[i].coachName}</Text>
                    <Text>{list[i].hourCount}</Text>
                    <Text>有效期限：无限</Text>
                </Body>
            </CardItem>)

        }
        return resultList;
    }


    render(){
        if(!this.state.datas){
            return(
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
            );
        }else {
            return (
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
                       {/* <Card dataArray={datas}
                              renderRow={data =>
                                  <CardItem>
                                      <Body>
                                      <Text>{data.hourName}</Text>
                                          <Text>{data.coachName}</Text>
                                          <Text>{data.hourCount}</Text>
                                          <Text>有效期限：无限</Text>
                                      </Body>
                                  </CardItem>}
                        />*/}
                        <Card>
                            {
                                this.cardItemList()
                            }
                        </Card>
                    </Content>
                </Container>
            )
        }
    }
}