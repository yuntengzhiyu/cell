<template>
    <div class="index">
        <div id="chart"></div>

<!--        <div class="navigator">-->
<!--            <div class="left">-->
<!--                <ul>-->
<!--                    <li>-->
<!--                        <router-link tag="span" to="/blogindex" style="cursor: pointer" class="index">{{decode_json}}</router-link>-->
<!--                    </li>-->
<!--                </ul>-->
<!--            </div>-->
<!--        </div>-->

    </div>
</template>

<script>
    import Plotly from 'plotly.js-dist'
    export default {
        name: "index",
        data(){
            return{
                visible: 'false',
                values: [10,20,30]

            }
        },
        mounted() {

            // this.draw()
            let chart = document.getElementById('chart')
            document.getElementById('chart').on('plotly_selected', function(eventData) {
                var selectedPoints = eventData.points;
                selectedPoints.forEach(function(point) {
                    console.log('Selected point:', point.x, point.y);
                });
            });

            // chart.on('plotly_click',function () {
            //     alert('点击')
            // })
            // chart.on('plotly_click', function(data){
            //     var pn='',
            //         tn='',
            //         colors=[];
            //     // console.log(data)
            //     // console.log(data.points.length)
            //     for(var i=0; i < data.points.length; i++){
            //         pn = data.points[i].pointNumber;      //当前trace的第几个点，点在簇内的编号
            //         // console.log(pn)
            //         tn = data.points[i].curveNumber;       //当前trace的簇的编号
            //         // console.log('tn'+tn)
            //         colors = data.points[i].data.marker.color; //data.points[i].data就是这个簇的所有点
            //         // console.log(colors)
            //     };
            //     colors[pn] = '#C54C82';
            //     //
            //     // var update = {'marker':{color: colors, size:16}};
            //     // Plotly.restyle('myDiv', update, [tn]);
            // });

        },
        methods:{
            draw(){
                var icon1 = {
                    'width': 500,
                    'height': 600,
                    'path': 'M224 512c35.32 0 63.97-28.65 63.97-64H160.03c0 35.35 28.65 64 63.97 64zm215.39-149.71c-19.32-20.76-55.47-51.99-55.47-154.29 0-77.7-54.48-139.9-127.94-155.16V32c0-17.67-14.32-32-31.98-32s-31.98 14.33-31.98 32v20.84C118.56 68.1 64.08 130.3 64.08 208c0 102.3-36.15 133.53-55.47 154.29-6 6.45-8.66 14.16-8.61 21.71.11 16.4 12.98 32 32.1 32h383.8c19.12 0 32-15.6 32.1-32 .05-7.55-2.61-15.27-8.61-21.71z'
                }
                var colors = ['green', 'red', 'blue']
                var config = {
                    // scrollZoom: true,        //缩放
                    toImageButtonOptions: {
                        format: 'svg', // one of png, svg, jpeg, webp
                        filename: 'custom_image',
                        height: 100,
                        width: 100,
                        scale: 1 // Multiply title/legend/axis/canvas sizes by this factor
                    },
                    displayModeBar: true,  //强制modebar始终可见，或者强制不可见
                    // modeBarButtonsToRemove: 'lasso2d',     //要删除的modebar按钮
                    modeBarButtonsToAdd: [
                        {
                            name: 'color toggler',
                            icon: icon1,
                            click: function(gd) {
                                var newColor = colors[Math.floor(3 * Math.random())]
                                Plotly.restyle(gd, 'marker.size', 20,[0],{
                                    // transition:{
                                    //     duration: 5500,
                                    //     easing: 'linear', //默认cubic-in-out
                                    // },
                                })
                            }},
                        {
                            name: 'button1',
                            icon: Plotly.Icons.pencil,
                            direction: 'up',
                            click: function(gd) {alert('button1')
                            }}],
                    showLink: true,
                    plotlyServerURL: "https://chart-studio.plotly.com",
                    displaylogo: false,
                    responsive: true, //响应式 根据窗口大小

                }
                var layout = {
                    title: 'Plotly Chart with Black Background',
                    paper_bgcolor: 'black', // 设置图表外部背景为黑色
                    plot_bgcolor: 'black',  // 设置绘图区域背景为黑色
                    showlegend: true,   //是否显示图例
                    font: {
                        color: 'white' // 设置文本颜色为白色，适应黑色背景
                    },
                    xaxis: {
                        showgrid: false,  // 隐藏x轴网格线
                        color: 'white',    // 设置x轴颜色为白色
                        autorange: true,
                        zeroline: false
                    },
                    yaxis: {
                        showgrid: false,  // 隐藏y轴网格线
                        color: 'white',    // 设置y轴颜色为白色
                        autorange: true,
                        zeroline: false
                    },
                    dragmode: 'pan',  // 设置拖动模式为 "pan"
                    hovermode: 'closest',
                    margin:{
                        // autoexpand: true ,
                        l: 0,
                        r: 0,
                        b: 0,
                        t: 0
                        // pad: 10
                    },
                    colorway:['yellow','green','red'],
                    // paper_bgcolor: 'blue',   //绘图纸的背景色
                    // margin:{t:0},
                    // width: 600,
                    // height: 400
                    // legends:[
                    //     {
                    //         id:'legend1'
                    //     }
                    // ]
                    modebar:{           //顶层模式 栏的设置
                        activecolor: 'red',
                        bgcolor: 'yellow',
                        color: 'grey',
                        // orientation: 'v',
                        remove: 'zoom2d',
                        add: 'lasso'
                    },
                    clickmode: 'event', // "event" is the default value and emits the `plotly_click` event. In addition this mode emits the `plotly_selected` event in drag modes "lasso" and "select",
                    activeselection:{       //被选中的区域
                        // fillcolor: 'black',
                        opacity: 1

                    },
                    hoverdistance: 10,  //只有鼠标距离点10个像素才会显示
                    hoverlabel:{
                        align: 'right',
                        bgcolor: 'black'
                    },
                    transition:{
                        duration: 500,
                        easing: 'linear', //默认cubic-in-out
                    },
                    meta:{
                        description: 'this is description'
                    },
                    // activeshape:{
                    //     fillcolor:' black'
                    // }
                    // annotations:{
                    //     text: 'import point',
                    //     x: 2,
                    //     y: 11,
                    //     ax: -40,
                    //     ay: -40,
                    //     showarrow: true,
                    //     bgcolor: 'red',
                    //     font:{
                    //         color: 'yellow'
                    //     }
                    // // }
                    // selections:{
                    //     line:{
                    //         color: 'red'
                    //     }
                    // }

                    // sliders: [{
                    //     active: 0,  // 初始激活的步数
                    //     currentvalue: {
                    //         font: {size: 20},
                    //         prefix: 'Step:',  // 显示的前缀
                    //         visible: true,
                    //         xanchor: 'right'  // 对齐方式
                    //     },
                    //     pad: {'t': 50},  // 内边距
                    //     len: 0.9,  // 滑块长度
                    //     x: 0.1,  // 滑块的 x 轴位置
                    //     y: 0,  // 滑块的 y 轴位置
                    //     steps: []  // 滑块的步骤数组
                    // }]
                    // updatemenus: [
                    //     {
                    //         bgcolor: 'blue',
                    //         bordercolor: 'yellow',
                    //         type: 'buttons', // 按钮类型
                    //         direction: 'left', // 按钮排列方向
                    //         buttons: [
                    //             {
                    //                 label: 'Line Chart', // 按钮标签
                    //                 method: 'relayout', // 更新图表方法
                    //                 args: ['xaxis.range', [0,10]], // 更新数据类型为散点图
                    //             },
                    //             {
                    //                 label: 'Bar Chart', // 按钮标签
                    //                 method: 'relayout', // 更新图表方法
                    //                 args: ['xaxis.range', [20,30]], // 更新数据类型为条形图
                    //             },
                    //         ],
                    //     },
                    // ],

                };

                let data1 = [
                    {
                        type: 'scatter',  // all "scatter" attributes: https://plotly.com/javascript/reference/#scatter
                        x: [1, 2, 3],     // more about "x": #scatter-x
                        y: [3, 1, 6],     // #scatter-y
                        marker: {         // marker is an object, valid marker keys: #scatter-marker
                            // color: 'rgb(16, 32, 77)' // more about "marker.color": #scatter-marker-color
                        },
                        name:'series1',
                        visible: this.visible, //false true
                        mode: 'markers' , //用线条连接散点， 'markers'仅仅显示数据点， 也可以是组合
                        zorder: 1,
                        showlegend: false
                    },
                    {
                        // type: 'bar',      // all "bar" chart attributes: #bar
                        // x: [1, 2, 3],     // more about "x": #bar-x
                        // y: [3, 1, 6],     // #bar-y
                        // name: 'bar chart example', // #bar-name,
                        // visible: 'false',
                        // showlegend: false,
                        // // legend:'legend1'
                        // legendwidth: 10,
                        // opacity: 0.5 ,         //数据图的透明度
                        // ids:['a','b','c']  ,       //
                        type: 'scatter',  // all "scatter" attributes: https://plotly.com/javascript/reference/#scatter
                        x: [-2, -3, 7],     // more about "x": #scatter-x
                        y: [3, 1, 10],     // #scatter-y
                        marker: {         // marker is an object, valid marker keys: #scatter-marker
                            // color: 'rgb(16, 32, 77)' // more about "marker.color": #scatter-marker-color
                        },
                        name:'series2',
                        visible: this.visible, //false true
                        mode: 'markers' , //用线条连接散点， 'markers'仅仅显示数据点， 也可以是组合
                        zorder: 1,
                        showlegend: false

                    },{
                        type: 'scatter',  // all "scatter" attributes: https://plotly.com/javascript/reference/#scatter
                        x: [2, 5, 3],     // more about "x": #scatter-x
                        y: [3, 4, 8],     // #scatter-y

                        marker: {         // marker is an object, valid marker keys: #scatter-marker
                            // color: 'red'
                        },
                        showlegend: false,
                        name:'series3',
                        visible: this.visible, //false true
                        mode: 'markers' , //用线条连接散点， 'markers'仅仅显示数据点， 也可以是组合
                        zorder: 0,       //显示数据的图层顺序
                        dx: 2  ,         //步长
                        text:['a','b','c']     ,//设置悬停字符
                        textposition: "bottom right",
                        hovertext: 'k',
                        hoverinfo: 'text'  ,      //鼠标悬停显示哪些信息， all所有信息， text仅显示text或者hovertext的文本
                        hoverlabel:{                   //悬停标签的设置
                          // bgcolor: 'yellow',
                            align: 'left',     //多行文本的对齐方式
                            bordercolor: 'black',
                            // borderpad: 10,
                          font:{
                              color: 'white',
                              family: 'Times New Roman',
                              //shadow 文字阴影
                              size: 10,

                              textcase: 'lower',

                          },

                        },
                        customdata: [10,20,30],
                        marker:{          //对标记进行设置
                            color: 'blue',
                            // colorscale: [
                            //     [0, 'rgb(255, 0, 0)'],   // 0% 处的颜色为红色
                            //     [0.5, 'rgb(255, 255, 0)'], // 50% 处的颜色为黄色
                            //     [1, 'rgb(0, 255, 0)']    // 100% 处的颜色为绿色
                            // ],
                            // colorscale: 'Rainbow',   //彩虹表
                            // colorbar:{         //颜色条
                            //     bgcolor:'red'
                            // },
                            // gradient:{
                            //     type: 'horizontal'          //标记点是水平渐变
                            // },
                            // size: [5,10,20],      //散点大小
                            sizemin: 6,       //渲染标记点的最小尺寸
                            maxdisplayed: 0   ,//不限制显示点数
                            // opacity: 0.5,  //标记不透明度
                            showscale: false ,//是否显示颜色条，前提要有color属性,
                            sizemode: 'diameter'
                        },
                        textfont:{          //设置文本字体
                            // color: 'blue'
                        },
                        selected:{              //被选择的点
                            marker:{
                                color: 'black' //opacity, size等等
                            }
                        },
                        unselected:{     //未选择的点
                            marker:{
                                size: 20
                            }
                        },
                        fillcolor: 'black', //填充颜色



                    }
                ];
                // Plotly.newPlot('chart',[{
                //     x:[1,2,3],
                //     y:[2,4,6],
                //     type:'scatter',
                //         mode:"markers",
                //         marker: { color: 'rgba(152, 0, 0, .8)' },
                // }],
                //     layout
                // )
                let graphDiv = document.getElementById("chart")
                Plotly.newPlot(graphDiv,data1,
                    layout,config
                )
                console.log(graphDiv.data)


                // let update = {
                //     opacity: 0.4,
                //     'marker.color': 'blue'
                // }
                // Plotly.restyle(graphDiv,update)    //重新绘制所有的trace，更改图中属性的有效方法
                //
                // let update1 = {
                //     'marker.color':['red','blue','green']
                //
                // }
                // Plotly.restyle(graphDiv,update1)
            }
        }
    }
</script>

<style scoped lang="less">
    /*.modebar-group{*/
    /*    background: transparent !important;*/
    /*}*/


    .index{
        /*background: black;*/
        height: 100%;
        display: flex;
        justify-content: center;
        align-items: center;
    }
    #chart{
        width: 60%;
        height: 100%;
        background: black;
        .modebar {
            background-color: blue !important; /* 背景色 */
        }
    }
/*.navigator{*/
/*    width: 100%;*/
/*    height: 56px;*/
/*    background: yellow;*/
/*    display: flex;*/
/*    justify-content: space-between;*/
/*    .left{*/
/*        height: 100%;*/

/*    }*/
/*    ul{*/
/*        display: flex;*/

/*        !*background: black;*!*/
/*        flex-direction: row;*/
/*        align-items: center;*/
/*        justify-content: flex-start;*/

/*        height: 100%;*/
/*        !*background: black;*!*/
/*        li{*/

/*            !*margin-right: 80px;*!*/
/*            !*background: red;*!*/
/*            font-size: 20px;*/
/*            color: black;*/
/*            font-weight: bold;*/
/*        }*/
/*    }*/
/*    .right{*/
/*        height: 100%;*/

/*    }*/

/*    !*background: black;*!*/

/*}*/
</style>
