import React, { Component } from 'react';
import {
    Container,
    Content,
} from "native-base";
import { Grid, Row } from "react-native-easy-grid";

import MyCharts from 'native-echarts';

export default class UserRecord extends Component {
    constructor(props) {
        super(props);
    }
    render() {
      const option = {
            title: {
                text: 'ECharts demo'
            },
            tooltip: {},
            legend: {
                data:['销量']
            },
            xAxis: {
                data: ["衬衫","羊毛衫","雪纺衫","裤子","高跟鞋","袜子"]
            },
            yAxis: {},
            series: [{
                name: '销量',
                type: 'bar',
                data: [5, 20, 36, 10, 10, 20]
            }]
        };
        return (
            <Container>
                <MyCharts option={option} height={300} />
            </Container>
               )
    }
}
