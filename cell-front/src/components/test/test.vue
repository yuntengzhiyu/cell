<template>
    <div class="test">
        <div id="chart"></div>

    </div>
</template>

<script>
    import Plotly from 'plotly.js-dist'
    export default {
        name: "test",
        data(){
            return{
                visible: 'false',
                values: [10,20,30],
                his_valuey: [
                    10,
                    2470.4,
                    4930.8,
                    7391.200000000001,
                    9851.6,
                    12312,
                    14772.400000000001,
                    17232.8,
                    19693.2,
                    22153.600000000002,
                    24614,
                    27074.4,
                    29534.800000000003,
                    31995.2,
                    34455.6,
                    36916,
                    39376.4,
                    41836.8,
                    44297.200000000004,
                    46757.6,
                    49218,
                    51678.4,
                    54138.8,
                    56599.200000000004,
                    59059.600000000006,
                    61520,
                    63980.4,
                    66440.8,
                    68901.2,
                    71361.6,
                    73822,
                    76282.40000000001,
                    78742.8,
                    81203.2,
                    83663.6,
                    86124,
                    88584.40000000001,
                    91044.8,
                    93505.2,
                    95965.6,
                    98426,
                    100886.40000000001,
                    103346.8,
                    105807.2,
                    108267.6,
                    110728,
                    113188.40000000001,
                    115648.8,
                    118109.20000000001,
                    120569.6,
                    0.000049044203662847485,
                    0.00016674585648973365,
                    0.00006680739037210183,
                    0.00003345593219726453,
                    0.000016313376957306642,
                    0.000008260505466792648,
                    0.000004656737902902891,
                    0.0000030701049475230567,
                    0.0000021138882853896927,
                    0.0000015374442033808112,
                    0.0000011026871494636232,
                    7.515964974953664e-7,
                    5.609024624919398e-7,
                    4.2278973572387677e-7,
                    2.746035231229809e-7,
                    2.4483179021141946e-7,
                    1.9645534681442613e-7,
                    1.0287233706386545e-7,
                    1.293816802877427e-7,
                    6.994814717282137e-8,
                    1.0376010091836382e-7,
                    7.500396962438243e-8,
                    6.633618790889468e-8,
                    4.7377790906323356e-8,
                    3.325734475233113e-8,
                    4.454218934939287e-8,
                    2.4283602060821088e-8,
                    1.9764960614357638e-8,
                    1.470498061763083e-8,
                    2.3567843669074772e-8,
                    1.8118324880672068e-8,
                    1.357892815959578e-8,
                    7.170934752461543e-9,
                    1.0181341858691717e-8,
                    9.197981478469865e-9,
                    6.8165566467464696e-9,
                    2.0779849882108757e-9,
                    6.919322709591728e-20,
                    9.368733131042566e-14,
                    2.666569297856319e-9,
                    6.546024125497437e-10,
                    1.4318608173769903e-19,
                    2.356047528570857e-9,
                    1.4526024339728332e-13,
                    9.085790256098103e-17,
                    4.9291543723918415e-9,
                    2.7780942640698567e-11,
                    1.5455762981329923e-26,
                    6.782366647290944e-38,
                    2.961024263677345e-16
                ],
                his_valuex:[ 10,
                    1312,
                    2577,
                    4950,
                    8509,
                    10,
                    123030
                ]
            }
        },
        mounted() {

            // this.draw()
            this.draw1()
            // let chart = document.getElementById('chart')
            // document.getElementById('chart').on('plotly_selected', function(eventData) {
            //     console.log(eventData)
            //
            //
            // });
            const chartElement = document.getElementById('chart');


        },
        methods:{

                // const data = Array.from({length: 2000}, () => Math.random() * 10000); // 用随机数据模
            //绘制kde
            draw1(){
                const x = [
                    10,
                    198.2,
                    386.4,
                    574.5999999999999,
                    762.8,
                    951,
                    1139.1999999999998,
                    1327.3999999999999,
                    1515.6,
                    1703.8,
                    1892,
                    2080.2,
                    2268.3999999999996,
                    2456.6,
                    2644.7999999999997,
                    2833,
                    3021.2,
                    3209.3999999999996,
                    3397.6,
                    3585.7999999999997,
                    3774,
                    3962.2,
                    4150.4,
                    4338.599999999999,
                    4526.799999999999,
                    4715,
                    4903.2,
                    5091.4,
                    5279.599999999999,
                    5467.799999999999,
                    5656,
                    5844.2,
                    6032.4,
                    6220.599999999999,
                    6408.799999999999,
                    6597,
                    6785.2,
                    6973.4,
                    7161.599999999999,
                    7349.799999999999,
                    7538,
                    7726.2,
                    7914.4,
                    8102.599999999999,
                    8290.8,
                    8479,
                    8667.199999999999,
                    8855.4,
                    9043.599999999999,
                    9231.8,
                ];
                const y = [
                    0.000006424650338696903,
                    0.00010852246276116355,
                    0.00045884529883418406,
                    0.0005456371109141766,
                    0.0005662606436447729,
                    0.0005370423453368713,
                    0.0004870763051240472,
                    0.00041652996461527737,
                    0.00035434534768764186,
                    0.00030116606876663405,
                    0.0002576841919788215,
                    0.00022003419722832425,
                    0.0001839392692067186,
                    0.00015428676639744156,
                    0.00013498415381247016,
                    0.00011317590180695378,
                    0.00009505249193143139,
                    0.00007831099416994735,
                    0.00006255631226452095,
                    0.00004947289704410009,
                    0.00003853223427042841,
                    0.000030401763539073624,
                    0.00002300311084859362,
                    0.000018303407215980046,
                    0.00001489295212125706,
                    0.000011402857155111892,
                    0.00000887402589475238,
                    0.0000074770774384784005,
                    0.0000056683548674457524,
                    0.0000041430748998749155,
                    0.0000035100146601404377,
                    0.000002911724778469155,
                    0.000002691694220869409,
                    0.0000018258645315706763,
                    0.0000015443310457702865,
                    0.0000014982038627946022,
                    0.0000010405046753198555,
                    0.0000011372729977815352,
                    9.172517590820937e-7,
                    6.938401819914769e-7,
                    6.808934552132598e-7,
                    5.389101141771334e-7,
                    3.3993221050675257e-7,
                    1.1438349089873759e-7,
                    1.9941782606292735e-7,
                    1.6542548402364924e-7,
                    5.7833617645987785e-8,
                    4.777349081497267e-9,
                    5.3239669301884385e-8,
                    5.2492963155615315e-8
                ];

// 创建Plotly图表
                const trace = {
                    x: x,
                    y: y,
                    type: 'scatter',
                    mode: 'lines',
                    line: { color: 'blue', width: 2 ,shape:'spline'},
                    // fillcolor: 'rgba(0, 100, 200, 0.2)',
                    fill: 'tozeroy',
                    fillgradient:{
                        colorscale: 'Viridis',
                        type: 'horizontal',
                        start: 9000,
                        stop: 0
                    },

                    dragmode: 'select',
                    marker:{
                        color: y,
                        colorscale: 'Viridis',
                        showscale: true,
                    }
                };

                const layout = {
                    title: 'Gene Count Distribution Density',
                    xaxis: { title: 'Gene Count',
                        // range: [0,9000]
                        range: [Math.min(...x), Math.max(...x)]
                    },
                    yaxis: {
                        title: 'Density' ,
                        fixedrange: true,
                        // range:[0,0.0006674585648973365,]
                        range: [0, Math.max(...y)]
                    },
                    dragmode : 'select',
                    selectdirection: 'h',
                    activeselection: {        //被选中的区域
                        fillcolor: 'blue',
                        opacity: 0.5
                    },
                    // newselection:{
                    //     line:{
                    //         color: 'black'
                    //     }
                    // },
                    transition:{
                        duration: 500,
                        easing: 'linear'
                    }
                };
                Plotly.newPlot('chart', [trace], layout);
            },
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

                let data2= [{

                    type: 'histogram',
                    name : 'trace1',
                    // x: this.his_valuex,
                    x: this.his_valuey,
                    // x: [1, 2, 2, 3, 4, 5, 5, 5, 6],
                    histnorm: 'probability density',
                    // histnorm: 'pro',
                    opacity: 0.7,
                    marker:{
                        color: 'rgba(31, 119, 180, 0.7)',
                        line: {
                            color: 'rgba(31, 119, 180, 1)',
                            width: 1
                        }
                    },
                    xbins:{

                    },


                }]
                let graphDiv = document.getElementById("chart")
                Plotly.newPlot(graphDiv,data2,
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


    .test{
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
