import React, { Component } from "react";
import {Dimensions, Image, StyleSheet, ToastAndroid, View} from "react-native";
import {
    Container,
    Header,
    Title,
    Content,
    Button,
    Icon,
    Card,
    CardItem,
    Text,
    Thumbnail,
    Left,
    Body,
    Right, StyleProvider
} from "native-base";
import {Grid,Row,Col} from "react-native-easy-grid";
import StorageUtil from "../utils/StorageUtil";
import HttpUtil from "../utils/HttpUtil";
import getTheme from "../../native-base-theme/components";
import material from "../../native-base-theme/variables/material";

const sankhadeep = require("../../img/header.jpg");
const DeviceWidth = Dimensions.get('window').width;

export default class ClubCard extends Component{
    constructor(props){
        super(props)
        this.state={
            cardInfo:''
        }
    }
    componentDidMount(): void {
        this.getCardInfo();
    }
    getCardInfo = () =>{
        StorageUtil.get('stuId', (error, object) => {
            if (!error && object && object.stuId) {
                const url = 'http://47.100.239.1:8080/api/card/getByStuId/'+object.stuId;
                //object.stuId;
                HttpUtil.get(url).then(result=>{
                    if(result.code===0){
                    //    ToastAndroid.show(result.msg,ToastAndroid.SHORT);
                        this.setState({cardInfo:result.data})
                        console.log(result.data[0].cardName)
                    }else{
                        ToastAndroid.show(result.msg,ToastAndroid.SHORT);
                    }

                }) .catch(error => {
                    console.log(error);
                })
            }})

    }

    render() {
        if(!this.state.cardInfo){
            return (
                <StyleProvider style={getTheme(material)}>
                <Container>
                    <Header>
                        <Left>
                            <Button transparent onPress={() => this.props.navigation.goBack()}>
                                <Icon name="arrow-back" />
                            </Button>
                        </Left>
                        <Body>
                            <Title>我的会员卡</Title>
                        </Body>
                        <Right />
                    </Header>

                    <Content padder>
                        <Text>Loading...</Text>
                    </Content>
                </Container>
                </StyleProvider>
            )
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
                            <Title>我的会员卡</Title>
                        </Body>
                        <Right/>
                    </Header>

                    <Content padder>
                        <View style={styles.card}>
                            <Row style={{marginTop: 20, marginLeft: 10}}>
                                <Col style={{width: '18%', paddingTop: 15}}>
                                    <Thumbnail source={sankhadeep}/>
                                </Col>
                                <Col style={{width: '52%'}}>
                                    <View style={styles.cardHeader}>
                                        <Text style={styles.cardHeaderText}>{this.state.cardInfo[0].stuName}</Text>
                                    </View>
                                    <View style={{flexDirection: 'row'}}>
                                        <Text style={{
                                            width: 50,
                                            height: 16,
                                            borderRadius: 8,
                                            fontSize: 12,
                                            backgroundColor: '#d8caaf',
                                            justifyContent: 'center',
                                            textAlign: 'center'
                                        }}>{this.state.cardInfo[0].cardName}</Text>
                                        <Text style={{
                                            fontSize: 12,
                                            marginLeft: 5
                                        }}>{this.state.cardInfo[0].dueDateStr}到期</Text>
                                    </View>
                                </Col>
                                <Col style={{width: '30%'}}>
                                    <View style={{
                                        width: '100%',
                                        height: 25,
                                        borderBottomLeftRadius: 12,
                                        borderTopLeftRadius: 12,
                                        backgroundColor: '#7b8b6f'
                                    }}>
                                        <Text style={{
                                            fontSize: 12,
                                            color: '#000000',
                                            marginLeft: 8,
                                            lineHeight: 25
                                        }}>小懒虫健身房</Text>
                                    </View>
                                </Col>
                            </Row>
                            <View style={{marginLeft: 10, marginBottom: 10}}>
                                <Text style={{fontSize: 10}}> 此卡仅限本人使用,如需转让请联系店员</Text>
                            </View>

                        </View>
                    </Content>
                </Container>
                </StyleProvider>
            );
        }
    }
}
const styles = StyleSheet.create({
card: {
    width: '100%',
    height: 150,
    backgroundColor: '#8696a7',
    marginTop: 0,
    marginBottom: 0,
    margin: 'auto',
    marginRight: 0,
    marginLeft: 0,
    borderRadius: 10,
    textAlign: 'center',
},
cardHeader: {
    width: '80%',
    textAlign: 'center',
    margin: 15
},
cardImg: {
    width: 50,
    height: 50,
    borderRadius: 25,
    borderWidth: 1
},
cardHeaderText: {
    color: '#ececea',
    fontSize: 17
}
})

