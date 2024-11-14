<template>
    <div class="login">

            <div id="chart"></div>
            <button @click="toggleVisibility">点击让第二类消失</button>
        <button @click="change_class">点击更换类别</button>
    </div>
</template>

<script>
    import Plotly from 'plotly.js-dist';
    import {generateColors} from "../../common/js/util";

    export default {
        name: 'login',
        data() {
            return {
                x: [],
                y: [],
                cell_type: [],
                class_num: 40,
                colors: [],
                visibleClasses: {},
                color_palette: {
                    "category": [
                        "discrete",
                        "default"
                    ],
                    "numeric": [
                        "sequence",
                        "YlGnBu"
                    ],
                    "expression": [
                        "sequence",
                        "YlOrRd"
                    ],
                    "discrete": {
                        "default": {
                            "id": "default",
                            "name": "default",
                            "colors": [
                                "#1f77b4",
                                "#ff7f0e",
                                "#2ca02c",
                                "#d62728",
                                "#9467bd",
                                "#8c564b",
                                "#e377c2",
                                "#bcbd22",
                                "#17becf",
                                "#aec7e8",
                                "#ffbb78",
                                "#98df8a",
                                "#ff9896",
                                "#c5b0d5",
                                "#c49c94",
                                "#f7b6d2",
                                "#c7c7c7",
                                "#dbdb8d",
                                "#9edae5"
                            ],
                            "creted_date": "",
                            "type": "bioturing"
                        },
                        "color_blind": {
                            "id": "color_blind",
                            "name": "color_blind",
                            "colors": [
                                "#332288",
                                "#117733",
                                "#44AA99",
                                "#88CCEE",
                                "#DDCC77",
                                "#CC6677",
                                "#AA4499",
                                "#882255"
                            ],
                            "creted_date": "",
                            "type": "bioturing"
                        },
                        "BioVinci": {
                            "id": "BioVinci",
                            "name": "BioVinci",
                            "colors": [
                                "#8E176A",
                                "#BF4C19",
                                "#0D703C",
                                "#258E99",
                                "#000E91",
                                "#190159",
                                "#FE0068",
                                "#7E0117",
                                "#FF4A86",
                                "#E2673B",
                                "#14A18A",
                                "#47B2A8",
                                "#2667C6",
                                "#5700E4",
                                "#FF0199",
                                "#E22303",
                                "#F17176",
                                "#F9B843",
                                "#BAD65B",
                                "#77C9BB",
                                "#2FBCD3",
                                "#7F29FE",
                                "#F63DFF",
                                "#FF6700",
                                "#FDAA92",
                                "#FFD833",
                                "#F0F93D",
                                "#6CF4DD",
                                "#43EDFF",
                                "#AF2BFC"
                            ],
                            "creted_date": "",
                            "type": "bioturing"
                        },
                        "grey": {
                            "id": "grey",
                            "name": "grey",
                            "colors": [
                                "#FAFAFA",
                                "#E0E0E0",
                                "#BDBDBD",
                                "#9E9E9E",
                                "#757575",
                                "#616161",
                                "#424242",
                                "#212121"
                            ],
                            "creted_date": "",
                            "type": "bioturing"
                        },
                        "BuGrey": {
                            "id": "BuGrey",
                            "name": "BuGrey",
                            "colors": [
                                "#ECEFF1",
                                "#90A4AE",
                                "#78909C",
                                "#607D8B",
                                "#546E7A",
                                "#455A64",
                                "#37474F",
                                "#263238"
                            ],
                            "creted_date": "",
                            "type": "bioturing"
                        },
                        "NPG": {
                            "id": "NPG",
                            "name": "NPG",
                            "colors": [
                                "#E64B35",
                                "#4DBBD5",
                                "#00A087",
                                "#3C5488",
                                "#F39B7F",
                                "#8491B4",
                                "#91D1C2",
                                "#DC0000",
                                "#7E6148",
                                "#B09C85"
                            ],
                            "creted_date": "",
                            "type": "bioturing"
                        },
                        "AAAS": {
                            "id": "AAAS",
                            "name": "AAAS",
                            "colors": [
                                "#3B4992",
                                "#EE0000",
                                "#008B45",
                                "#631879",
                                "#008280",
                                "#BB0021",
                                "#5F559B",
                                "#A20056",
                                "#808180",
                                "#1B1919"
                            ],
                            "creted_date": "",
                            "type": "bioturing"
                        },
                        "NEJM": {
                            "id": "NEJM",
                            "name": "NEJM",
                            "colors": [
                                "#BC3C29",
                                "#0072B5",
                                "#E18727",
                                "#20854E",
                                "#7876B1",
                                "#6F99AD",
                                "#FFDC91",
                                "#EE4C97"
                            ],
                            "creted_date": "",
                            "type": "bioturing"
                        },
                        "LANCET": {
                            "id": "LANCET",
                            "name": "LANCET",
                            "colors": [
                                "#00468B",
                                "#ED0000",
                                "#42B540",
                                "#0099B4",
                                "#925E9F",
                                "#FDAF91",
                                "#AD002A",
                                "#ADB6B6",
                                "#1B1919"
                            ],
                            "creted_date": "",
                            "type": "bioturing"
                        },
                        "JAMA": {
                            "id": "JAMA",
                            "name": "JAMA",
                            "colors": [
                                "#374E55",
                                "#DF8F44",
                                "#00A1D5",
                                "#B24745",
                                "#79AF97",
                                "#6A6599",
                                "#80796B"
                            ],
                            "creted_date": "",
                            "type": "bioturing"
                        },
                        "JCO": {
                            "id": "JCO",
                            "name": "JCO",
                            "colors": [
                                "#0073C2",
                                "#EFC000",
                                "#868686",
                                "#CD534C",
                                "#7AA6DC",
                                "#003C67",
                                "#8F7700",
                                "#3B3B3B",
                                "#A73030",
                                "#4A6990"
                            ],
                            "creted_date": "",
                            "type": "bioturing"
                        },
                        "UCSCGB": {
                            "id": "UCSCGB",
                            "name": "UCSCGB",
                            "colors": [
                                "#FF0000",
                                "#FF9900",
                                "#FFCC00",
                                "#00FF00",
                                "#6699FF",
                                "#CC33FF",
                                "#99991E",
                                "#999999",
                                "#FF00CC",
                                "#CC0000",
                                "#FFCCCC",
                                "#FFFF00",
                                "#CCFF00",
                                "#358000",
                                "#0000CC",
                                "#99CCFF",
                                "#00FFFF",
                                "#CCFFFF",
                                "#9900CC",
                                "#CC99FF",
                                "#996600",
                                "#666600",
                                "#666666",
                                "#CCCCCC",
                                "#79CC3D",
                                "#CCCC99"
                            ],
                            "creted_date": "",
                            "type": "bioturing"
                        },
                        "d3_10": {
                            "id": "d3_10",
                            "name": "d3_10",
                            "colors": [
                                "#1F77B4",
                                "#FF7F0E",
                                "#2CA02C",
                                "#D62728",
                                "#9467BD",
                                "#8C564B",
                                "#E377C2",
                                "#7F7F7F",
                                "#BCBD22",
                                "#17BECF"
                            ],
                            "creted_date": "",
                            "type": "bioturing"
                        },
                        "d3_20": {
                            "id": "d3_20",
                            "name": "d3_20",
                            "colors": [
                                "#1F77B4",
                                "#FF7F0E",
                                "#2CA02C",
                                "#D62728",
                                "#9467BD",
                                "#8C564B",
                                "#E377C2",
                                "#7F7F7F",
                                "#BCBD22",
                                "#17BECF",
                                "#AEC7E8",
                                "#FFBB78",
                                "#98DF8A",
                                "#FF9896",
                                "#C5B0D5",
                                "#C49C94",
                                "#F7B6D2",
                                "#C7C7C7",
                                "#DBDB8D",
                                "#9EDAE5"
                            ],
                            "creted_date": "",
                            "type": "bioturing"
                        },
                        "d3_20b": {
                            "id": "d3_20b",
                            "name": "d3_20b",
                            "colors": [
                                "#393B79",
                                "#637939",
                                "#8C6D31",
                                "#843C39",
                                "#7B4173",
                                "#5254A3",
                                "#8CA252",
                                "#BD9E39",
                                "#AD494A",
                                "#A55194",
                                "#6B6ECF",
                                "#B5CF6B",
                                "#E7BA52",
                                "#D6616B",
                                "#CE6DBD",
                                "#9C9EDE",
                                "#CEDB9C",
                                "#E7CB94",
                                "#E7969C",
                                "#DE9ED6"
                            ],
                            "creted_date": "",
                            "type": "bioturing"
                        },
                        "d3_20c": {
                            "id": "d3_20c",
                            "name": "d3_20c",
                            "colors": [
                                "#3182BD",
                                "#E6550D",
                                "#31A354",
                                "#756BB1",
                                "#636363",
                                "#6BAED6",
                                "#FD8D3C",
                                "#74C476",
                                "#9E9AC8",
                                "#969696",
                                "#9ECAE1",
                                "#FDAE6B",
                                "#A1D99B",
                                "#BCBDDC",
                                "#BDBDBD",
                                "#C6DBEF",
                                "#FDD0A2",
                                "#C7E9C0",
                                "#DADAEB",
                                "#D9D9D9"
                            ],
                            "creted_date": "",
                            "type": "bioturing"
                        },
                        "U": {
                            "id": "U",
                            "name": "U",
                            "colors": [
                                "#800000",
                                "#767676",
                                "#FFA319",
                                "#8A9045",
                                "#155F83",
                                "#C16622",
                                "#8F3931",
                                "#58593F",
                                "#350E20"
                            ],
                            "creted_date": "",
                            "type": "bioturing"
                        },
                        "U_light": {
                            "id": "U_light",
                            "name": "U_light",
                            "colors": [
                                "#800000",
                                "#D6D6CE",
                                "#FFB547",
                                "#ADB17D",
                                "#5B8FA8",
                                "#D49464",
                                "#B1746F",
                                "#8A8B79",
                                "#725663"
                            ],
                            "creted_date": "",
                            "type": "bioturing"
                        },
                        "U_dark": {
                            "id": "U_dark",
                            "name": "U_dark",
                            "colors": [
                                "#800000",
                                "#767676",
                                "#CC8214",
                                "#616530",
                                "#0F425C",
                                "#9A5324",
                                "#642822",
                                "#3E3E23",
                                "#350E20"
                            ],
                            "creted_date": "",
                            "type": "bioturing"
                        },
                        "google": {
                            "id": "google",
                            "name": "google",
                            "colors": [
                                "#3366cc",
                                "#dc3912",
                                "#ff9900",
                                "#109618",
                                "#990099",
                                "#0099c6",
                                "#dd4477",
                                "#66aa00",
                                "#b82e2e",
                                "#316395",
                                "#994499",
                                "#22aa99",
                                "#aaaa11",
                                "#6633cc",
                                "#e67300",
                                "#8b0707",
                                "#651067",
                                "#329262",
                                "#5574a6",
                                "#3b3eac"
                            ],
                            "creted_date": "",
                            "type": "bioturing"
                        },
                        "paired": {
                            "id": "paired",
                            "name": "paired",
                            "colors": [
                                "#A6CEE3",
                                "#1F78B4",
                                "#B2DF8A",
                                "#33A02C",
                                "#FB9A99",
                                "#E31A1C",
                                "#FDBF6F",
                                "#FF7F00",
                                "#CAB2D6",
                                "#6A3D9A",
                                "#FFFF99",
                                "#B15928"
                            ],
                            "creted_date": "",
                            "type": "bioturing"
                        },
                        "set1": {
                            "id": "set1",
                            "name": "set1",
                            "colors": [
                                "#8DD3C7",
                                "#FFFFB3",
                                "#BEBADA",
                                "#FB8072",
                                "#80B1D3",
                                "#FDB462",
                                "#B3DE69",
                                "#FCCDE5",
                                "#D9D9D9",
                                "#BC80BD",
                                "#CCEBC5",
                                "#FFED6F"
                            ],
                            "creted_date": "",
                            "type": "bioturing"
                        },
                        "set2": {
                            "id": "set2",
                            "name": "set2",
                            "colors": [
                                "#E41A1C",
                                "#377EB8",
                                "#4DAF4A",
                                "#984EA3",
                                "#FF7F00",
                                "#FFFF33",
                                "#A65628",
                                "#F781BF",
                                "#999999"
                            ],
                            "creted_date": "",
                            "type": "bioturing"
                        },
                        "set3": {
                            "id": "set3",
                            "name": "set3",
                            "colors": [
                                "#66C2A5",
                                "#FC8D62",
                                "#8DA0CB",
                                "#E78AC3",
                                "#A6D854",
                                "#FFD92F",
                                "#E5C494",
                                "#B3B3B3"
                            ],
                            "creted_date": "",
                            "type": "bioturing"
                        },
                        "pastel1": {
                            "id": "pastel1",
                            "name": "pastel1",
                            "colors": [
                                "#FBB4AE",
                                "#B3CDE3",
                                "#CCEBC5",
                                "#DECBE4",
                                "#FED9A6",
                                "#FFFFCC",
                                "#E5D8BD",
                                "#FDDAEC",
                                "#F2F2F2"
                            ],
                            "creted_date": "",
                            "type": "bioturing"
                        },
                        "pastel2": {
                            "id": "pastel2",
                            "name": "pastel2",
                            "colors": [
                                "#B3E2CD",
                                "#FDCDAC",
                                "#CBD5E8",
                                "#F4CAE4",
                                "#E6F5C9",
                                "#FFF2AE",
                                "#F1E2CC",
                                "#CCCCCC"
                            ],
                            "creted_date": "",
                            "type": "bioturing"
                        },
                        "dark": {
                            "id": "dark",
                            "name": "dark",
                            "colors": [
                                "#1B9E77",
                                "#D95F02",
                                "#7570B3",
                                "#E7298A",
                                "#66A61E",
                                "#E6AB02",
                                "#A6761D",
                                "#666666"
                            ],
                            "creted_date": "",
                            "type": "bioturing"
                        },
                        "accent": {
                            "id": "accent",
                            "name": "accent",
                            "colors": [
                                "#7FC97F",
                                "#BEAED4",
                                "#FDC086",
                                "#FFFF99",
                                "#386CB0",
                                "#F0027F",
                                "#BF5B17",
                                "#666666"
                            ],
                            "creted_date": "",
                            "type": "bioturing"
                        },
                        "ggplot": {
                            "id": "ggplot",
                            "name": "ggplot",
                            "colors": [
                                "#f8756c",
                                "#a3a500",
                                "#02bf7d",
                                "#01b0f6",
                                "#e76af3"
                            ],
                            "creted_date": "",
                            "type": "bioturing"
                        }
                    },
                    "sequence": {
                        "YlGn": {
                            "id": "YlGn",
                            "name": "YlGn",
                            "colors": [
                                "#ffffe5",
                                "#f7fcb9",
                                "#d9f0a3",
                                "#addd8e",
                                "#78c679",
                                "#41ab5d",
                                "#238443",
                                "#006837",
                                "#004529"
                            ],
                            "creted_date": "",
                            "type": "bioturing"
                        },
                        "YlGnBu": {
                            "id": "YlGnBu",
                            "name": "YlGnBu",
                            "colors": [
                                "#ffffd9",
                                "#edf8b1",
                                "#c7e9b4",
                                "#7fcdbb",
                                "#41b6c4",
                                "#1d91c0",
                                "#225ea8",
                                "#253494",
                                "#081d58"
                            ],
                            "creted_date": "",
                            "type": "bioturing"
                        },
                        "GnBu": {
                            "id": "GnBu",
                            "name": "GnBu",
                            "colors": [
                                "#f7fcf0",
                                "#e0f3db",
                                "#ccebc5",
                                "#a8ddb5",
                                "#7bccc4",
                                "#4eb3d3",
                                "#2b8cbe",
                                "#0868ac",
                                "#084081"
                            ],
                            "creted_date": "",
                            "type": "bioturing"
                        },
                        "BuGn": {
                            "id": "BuGn",
                            "name": "BuGn",
                            "colors": [
                                "#f7fcfd",
                                "#e5f5f9",
                                "#ccece6",
                                "#99d8c9",
                                "#66c2a4",
                                "#41ae76",
                                "#238b45",
                                "#006d2c",
                                "#00441b"
                            ],
                            "creted_date": "",
                            "type": "bioturing"
                        },
                        "PuBuGn": {
                            "id": "PuBuGn",
                            "name": "PuBuGn",
                            "colors": [
                                "#fff7fb",
                                "#ece2f0",
                                "#d0d1e6",
                                "#a6bddb",
                                "#67a9cf",
                                "#3690c0",
                                "#02818a",
                                "#016c59",
                                "#014636"
                            ],
                            "creted_date": "",
                            "type": "bioturing"
                        },
                        "PuBu": {
                            "id": "PuBu",
                            "name": "PuBu",
                            "colors": [
                                "#fff7fb",
                                "#ece7f2",
                                "#d0d1e6",
                                "#a6bddb",
                                "#74a9cf",
                                "#3690c0",
                                "#0570b0",
                                "#045a8d",
                                "#023858"
                            ],
                            "creted_date": "",
                            "type": "bioturing"
                        },
                        "BuPu": {
                            "id": "BuPu",
                            "name": "BuPu",
                            "colors": [
                                "#f7fcfd",
                                "#e0ecf4",
                                "#bfd3e6",
                                "#9ebcda",
                                "#8c96c6",
                                "#8c6bb1",
                                "#88419d",
                                "#810f7c",
                                "#4d004b"
                            ],
                            "creted_date": "",
                            "type": "bioturing"
                        },
                        "RdPu": {
                            "id": "RdPu",
                            "name": "RdPu",
                            "colors": [
                                "#fff7f3",
                                "#fde0dd",
                                "#fcc5c0",
                                "#fa9fb5",
                                "#f768a1",
                                "#dd3497",
                                "#ae017e",
                                "#7a0177",
                                "#49006a"
                            ],
                            "creted_date": "",
                            "type": "bioturing"
                        },
                        "PuRd": {
                            "id": "PuRd",
                            "name": "PuRd",
                            "colors": [
                                "#f7f4f9",
                                "#e7e1ef",
                                "#d4b9da",
                                "#c994c7",
                                "#df65b0",
                                "#e7298a",
                                "#ce1256",
                                "#980043",
                                "#67001f"
                            ],
                            "creted_date": "",
                            "type": "bioturing"
                        },
                        "OrRd": {
                            "id": "OrRd",
                            "name": "OrRd",
                            "colors": [
                                "#fff7ec",
                                "#fee8c8",
                                "#fdd49e",
                                "#fdbb84",
                                "#fc8d59",
                                "#ef6548",
                                "#d7301f",
                                "#b30000",
                                "#7f0000"
                            ],
                            "creted_date": "",
                            "type": "bioturing"
                        },
                        "YlOrRd": {
                            "id": "YlOrRd",
                            "name": "YlOrRd",
                            "colors": [
                                "#ffffcc",
                                "#ffeda0",
                                "#fed976",
                                "#feb24c",
                                "#fd8d3c",
                                "#fc4e2a",
                                "#e31a1c",
                                "#bd0026",
                                "#800026"
                            ],
                            "creted_date": "",
                            "type": "bioturing"
                        },
                        "YlOrBr": {
                            "id": "YlOrBr",
                            "name": "YlOrBr",
                            "colors": [
                                "#ffffe5",
                                "#fff7bc",
                                "#fee391",
                                "#fec44f",
                                "#fe9929",
                                "#ec7014",
                                "#cc4c02",
                                "#993404",
                                "#662506"
                            ],
                            "creted_date": "",
                            "type": "bioturing"
                        },
                        "Purples": {
                            "id": "Purples",
                            "name": "Purples",
                            "colors": [
                                "#fcfbfd",
                                "#efedf5",
                                "#dadaeb",
                                "#bcbddc",
                                "#9e9ac8",
                                "#807dba",
                                "#6a51a3",
                                "#54278f",
                                "#3f007d"
                            ],
                            "creted_date": "",
                            "type": "bioturing"
                        },
                        "Blues": {
                            "id": "Blues",
                            "name": "Blues",
                            "colors": [
                                "#f7fbff",
                                "#deebf7",
                                "#c6dbef",
                                "#9ecae1",
                                "#6baed6",
                                "#4292c6",
                                "#2171b5",
                                "#08519c",
                                "#08306b"
                            ],
                            "creted_date": "",
                            "type": "bioturing"
                        },
                        "Greens": {
                            "id": "Greens",
                            "name": "Greens",
                            "colors": [
                                "#f7fcf5",
                                "#e5f5e0",
                                "#c7e9c0",
                                "#a1d99b",
                                "#74c476",
                                "#41ab5d",
                                "#238b45",
                                "#006d2c",
                                "#00441b"
                            ],
                            "creted_date": "",
                            "type": "bioturing"
                        },
                        "Oranges": {
                            "id": "Oranges",
                            "name": "Oranges",
                            "colors": [
                                "#fff5eb",
                                "#fee6ce",
                                "#fdd0a2",
                                "#fdae6b",
                                "#fd8d3c",
                                "#f16913",
                                "#d94801",
                                "#a63603",
                                "#7f2704"
                            ],
                            "creted_date": "",
                            "type": "bioturing"
                        },
                        "Reds": {
                            "id": "Reds",
                            "name": "Reds",
                            "colors": [
                                "#fff5f0",
                                "#fee0d2",
                                "#fcbba1",
                                "#fc9272",
                                "#fb6a4a",
                                "#ef3b2c",
                                "#cb181d",
                                "#a50f15",
                                "#67000d"
                            ],
                            "creted_date": "",
                            "type": "bioturing"
                        },
                        "Greys": {
                            "id": "Greys",
                            "name": "Greys",
                            "colors": [
                                "#ffffff",
                                "#f0f0f0",
                                "#d9d9d9",
                                "#bdbdbd",
                                "#969696",
                                "#737373",
                                "#525252",
                                "#252525",
                                "#000000"
                            ],
                            "creted_date": "",
                            "type": "bioturing"
                        },
                        "PuOr": {
                            "id": "PuOr",
                            "name": "PuOr",
                            "colors": [
                                "#7f3b08",
                                "#b35806",
                                "#e08214",
                                "#fdb863",
                                "#fee0b6",
                                "#f7f7f7",
                                "#d8daeb",
                                "#b2abd2",
                                "#8073ac",
                                "#542788",
                                "#2d004b"
                            ],
                            "creted_date": "",
                            "type": "bioturing"
                        },
                        "BrBG": {
                            "id": "BrBG",
                            "name": "BrBG",
                            "colors": [
                                "#543005",
                                "#8c510a",
                                "#bf812d",
                                "#dfc27d",
                                "#f6e8c3",
                                "#f5f5f5",
                                "#c7eae5",
                                "#80cdc1",
                                "#35978f",
                                "#01665e",
                                "#003c30"
                            ],
                            "creted_date": "",
                            "type": "bioturing"
                        },
                        "GnRP": {
                            "id": "GnRP",
                            "name": "GnRP",
                            "colors": [
                                "#00441b",
                                "#1b7837",
                                "#5aae61",
                                "#a6dba0",
                                "#d9f0d3",
                                "#f7f7f7",
                                "#e7d4e8",
                                "#c2a5cf",
                                "#9970ab",
                                "#762a83",
                                "#40004b"
                            ],
                            "creted_date": "",
                            "type": "bioturing"
                        },
                        "GYPi": {
                            "id": "GYPi",
                            "name": "GYPi",
                            "colors": [
                                "#276419",
                                "#4d9221",
                                "#7fbc41",
                                "#b8e186",
                                "#e6f5d0",
                                "#f7f7f7",
                                "#fde0ef",
                                "#f1b6da",
                                "#de77ae",
                                "#c51b7d",
                                "#8e0152"
                            ],
                            "creted_date": "",
                            "type": "bioturing"
                        },
                        "BuRd": {
                            "id": "BuRd",
                            "name": "BuRd",
                            "colors": [
                                "#053061",
                                "#2166ac",
                                "#4393c3",
                                "#92c5de",
                                "#d1e5f0",
                                "#f7f7f7",
                                "#fddbc7",
                                "#f4a582",
                                "#d6604d",
                                "#b2182b",
                                "#67001f"
                            ],
                            "creted_date": "",
                            "type": "bioturing"
                        },
                        "GyRd": {
                            "id": "GyRd",
                            "name": "GyRd",
                            "colors": [
                                "#1a1a1a",
                                "#4d4d4d",
                                "#878787",
                                "#bababa",
                                "#e0e0e0",
                                "#ffffff",
                                "#fddbc7",
                                "#f4a582",
                                "#d6604d",
                                "#b2182b",
                                "#67001f"
                            ],
                            "creted_date": "",
                            "type": "bioturing"
                        },
                        "BuYlRd": {
                            "id": "BuYlRd",
                            "name": "BuYlRd",
                            "colors": [
                                "#313695",
                                "#4575b4",
                                "#74add1",
                                "#abd9e9",
                                "#e0f3f8",
                                "#ffffbf",
                                "#fee090",
                                "#fdae61",
                                "#f46d43",
                                "#d73027",
                                "#a50026"
                            ],
                            "creted_date": "",
                            "type": "bioturing"
                        },
                        "Spectral": {
                            "id": "Spectral",
                            "name": "Spectral",
                            "colors": [
                                "#5e4fa2",
                                "#3288bd",
                                "#66c2a5",
                                "#abdda4",
                                "#e6f598",
                                "#ffffbf",
                                "#fee08b",
                                "#fdae61",
                                "#f46d43",
                                "#d53e4f",
                                "#9e0142"
                            ],
                            "creted_date": "",
                            "type": "bioturing"
                        },
                        "GnYlRd": {
                            "id": "GnYlRd",
                            "name": "GnYlRd",
                            "colors": [
                                "#006837",
                                "#1a9850",
                                "#66bd63",
                                "#a6d96a",
                                "#d9ef8b",
                                "#ffffbf",
                                "#fee08b",
                                "#fdae61",
                                "#f46d43",
                                "#d73027",
                                "#a50026"
                            ],
                            "creted_date": "",
                            "type": "bioturing"
                        },
                        "Diff": {
                            "id": "Diff",
                            "name": "Diff",
                            "colors": [
                                "#FFE680",
                                "#FFDC61",
                                "#FFD343",
                                "#FFCA25",
                                "#FFC207",
                                "#FFBA00",
                                "#FFB200",
                                "#FFAB00",
                                "#FFA300",
                                "#FF9C00",
                                "#FF9400",
                                "#FF8D00",
                                "#FF8500",
                                "#FF7E00",
                                "#FF7600",
                                "#FF6F00",
                                "#FF6700",
                                "#FF6000",
                                "#FF5800",
                                "#FF5100",
                                "#FF4900",
                                "#FF4200",
                                "#FF3500",
                                "#FF2600",
                                "#FF1700",
                                "#FF0800",
                                "#FB0000",
                                "#F40000",
                                "#ED0000",
                                "#E60000",
                                "#DE0000",
                                "#D80000",
                                "#D10000",
                                "#CB0000",
                                "#C40000",
                                "#BA0000",
                                "#B00000",
                                "#A80000",
                                "#A20000",
                                "#9B0000",
                                "#930000",
                                "#8C0000",
                                "#840000",
                                "#7D0000",
                                "#750000",
                                "#6E0000",
                                "#660000",
                                "#5F0000",
                                "#570000",
                                "#500000"
                            ],
                            "creted_date": "",
                            "type": "bioturing"
                        },
                        "Diff1": {
                            "id": "Diff1",
                            "name": "Diff1",
                            "colors": [
                                "#0000FF",
                                "#3939FF",
                                "#5151FF",
                                "#6262FF",
                                "#7070FF",
                                "#7D7DFF",
                                "#8888FF",
                                "#9292FF",
                                "#9B9BFF",
                                "#A3A3FF",
                                "#ABABFF",
                                "#B3B3FF",
                                "#BABAFF",
                                "#C1C1FF",
                                "#C7C7FF",
                                "#CDCDFF",
                                "#D3D3FF",
                                "#D9D9FF",
                                "#DFDFFF",
                                "#E4E4FF",
                                "#E9E9FF",
                                "#EEEEFF",
                                "#F3F3FF",
                                "#F8F8FF",
                                "#FDFDFF",
                                "#FFFDFD",
                                "#FFF8F8",
                                "#FFF3F3",
                                "#FFEEEE",
                                "#FFE9E9",
                                "#FFE4E4",
                                "#FFDFDF",
                                "#FFD9D9",
                                "#FFD3D3",
                                "#FFCDCD",
                                "#FFC7C7",
                                "#FFC1C1",
                                "#FFBABA",
                                "#FFB3B3",
                                "#FFABAB",
                                "#FFA3A3",
                                "#FF9B9B",
                                "#FF9292",
                                "#FF8888",
                                "#FF7D7D",
                                "#FF7070",
                                "#FF6262",
                                "#FF5151",
                                "#FF3939",
                                "#FF0000"
                            ],
                            "creted_date": "",
                            "type": "bioturing"
                        },
                        "Diff2": {
                            "id": "Diff2",
                            "name": "Diff2",
                            "colors": [
                                "#023FA5",
                                "#2749A4",
                                "#3952A5",
                                "#475BA8",
                                "#5364AB",
                                "#5E6DAE",
                                "#6875B1",
                                "#727EB5",
                                "#7C86B9",
                                "#858EBC",
                                "#8E96C0",
                                "#969DC3",
                                "#9FA4C7",
                                "#A6ACCA",
                                "#AEB2CD",
                                "#B5B9D0",
                                "#BCBFD3",
                                "#C3C5D6",
                                "#C9CBD8",
                                "#CED0DA",
                                "#D4D5DC",
                                "#D8D9DE",
                                "#DCDDE0",
                                "#DFE0E1",
                                "#E2E2E2",
                                "#E2E2E2",
                                "#E1DFE0",
                                "#E0DCDC",
                                "#DFD7D9",
                                "#DED2D4",
                                "#DCCDCF",
                                "#DAC7CA",
                                "#D8C0C4",
                                "#D5B9BE",
                                "#D3B2B8",
                                "#D0AAB1",
                                "#CDA2AA",
                                "#C99AA2",
                                "#C6919B",
                                "#C28893",
                                "#BE7F8B",
                                "#BA7583",
                                "#B56B7A",
                                "#B06072",
                                "#AB5669",
                                "#A64A60",
                                "#A13E57",
                                "#9B304E",
                                "#952045",
                                "#8E063B"
                            ],
                            "creted_date": "",
                            "type": "bioturing"
                        },
                        "Heat1": {
                            "id": "Heat1",
                            "name": "Heat1",
                            "colors": [
                                "#E2E6BD",
                                "#E2E688",
                                "#E2E37C",
                                "#E3E073",
                                "#E4DD6B",
                                "#E4DA64",
                                "#E5D75D",
                                "#E6D457",
                                "#E6D151",
                                "#E7CE4C",
                                "#E7CB46",
                                "#E8C742",
                                "#E8C43D",
                                "#E8C139",
                                "#E9BE35",
                                "#E9BA31",
                                "#E9B72E",
                                "#E9B42C",
                                "#EAB02A",
                                "#EAAD29",
                                "#EAAA28",
                                "#EAA628",
                                "#E9A328",
                                "#E99F2A",
                                "#E99C2B",
                                "#E9992D",
                                "#E8952F",
                                "#E89231",
                                "#E88E34",
                                "#E78B37",
                                "#E78839",
                                "#E6843C",
                                "#E5813F",
                                "#E57D42",
                                "#E47A45",
                                "#E37647",
                                "#E2724A",
                                "#E16F4D",
                                "#E06B50",
                                "#DF6752",
                                "#DE6455",
                                "#DD6057",
                                "#DC5C5A",
                                "#DB585C",
                                "#D9545F",
                                "#D85161",
                                "#D74C63",
                                "#D54866",
                                "#D44468",
                                "#D33F6A"
                            ],
                            "creted_date": "",
                            "type": "bioturing"
                        },
                        "Heat2": {
                            "id": "Heat2",
                            "name": "Heat2",
                            "colors": [
                                "#dcdcdc",
                                "#dfd9d5",
                                "#e1d7cf",
                                "#e4d4c8",
                                "#e6d2c2",
                                "#e9cfbb",
                                "#ecccb5",
                                "#eecaae",
                                "#f1c7a8",
                                "#f3c5a1",
                                "#f5c29b",
                                "#f5be95",
                                "#f5ba90",
                                "#f5b78b",
                                "#f5b385",
                                "#f5af80",
                                "#f5ac7a",
                                "#f5a875",
                                "#f5a470",
                                "#f5a16a",
                                "#f39c67",
                                "#f19764",
                                "#ee9162",
                                "#ec8c5f",
                                "#ea875c",
                                "#e88259",
                                "#e57d57",
                                "#e37754",
                                "#e17251",
                                "#de6d4f",
                                "#dc684c",
                                "#da6349",
                                "#d75d47",
                                "#d55844",
                                "#d35341",
                                "#d04e3f",
                                "#ce483c",
                                "#cc4339",
                                "#c93e37",
                                "#c73934",
                                "#c53431",
                                "#c22e2f",
                                "#c0292c",
                                "#be2429",
                                "#bb1f27",
                                "#b91a24",
                                "#b71421",
                                "#b40f1f",
                                "#b20a1c"
                            ],
                            "creted_date": "",
                            "type": "bioturing"
                        },
                        "Ice": {
                            "id": "Ice",
                            "name": "Ice",
                            "colors": [
                                "#eafcfd",
                                "#c0e5e8",
                                "#95cfd8",
                                "#72b8cd",
                                "#599fc4",
                                "#4886bb",
                                "#3e6db2",
                                "#3e53a0",
                                "#3a3c7d",
                                "#2c2a57",
                                "#191933",
                                "#030512"
                            ],
                            "creted_date": "",
                            "type": "bioturing"
                        },
                        "SkyBlue": {
                            "id": "SkyBlue",
                            "name": "SkyBlue",
                            "colors": [
                                "#F0F9FD",
                                "#E1F3FA",
                                "#D2EDF8",
                                "#C3E7F5",
                                "#B4E0F3",
                                "#A5DAF0",
                                "#96D4EE",
                                "#87CEEB",
                                "#76B4CE",
                                "#659BB0",
                                "#548193",
                                "#446776",
                                "#334D58",
                                "#22343B",
                                "#111A1D"
                            ],
                            "creted_date": "",
                            "type": "bioturing"
                        }
                    }
                },
            };
        },
        mounted() {
            // this.draw2()


            // this.draw1()
            // this.getcelldata().then(() => {
            //     this.draw()
            // });
        },
        created(){


        },
        methods: {
            draw2(){
                // 假设有以下数据数组
                var data = [
                    {type: 'box', name: 'Sample Data', y: [1, 2, 3, 4, 5]}
                ];

// 箱型图的基本配置
                var layout = {
                    title: 'Example Box Plot',
                    yaxis: {title: 'Values'},
                    boxmode: 'group' // 如果你有多个箱子想要对比，设置为"group"
                };

// 渲染图表
                Plotly.newPlot('chart', data, layout);
            },
            async change_class(){
                const {data: res} = await this.$http.get('getclass')
                this.cell_type = res.data
                this.class_num = Math.max(...this.cell_type) + 1
                this.colors = generateColors(this.class_num)
                let newMarkerColors = this.cell_type.map(c => this.colors[c])
                Plotly.restyle('chart', { 'marker.color': [newMarkerColors] });

                // this.cell_type = [0,0,1,1,1,0,0,1,1]
                // this.class_num = Math.max(...this.cell_type) + 1
                // this.colors = generateColors(this.class_num)
                // console.log(this.colors)
                // let newMarkerColors = this.cell_type.map(c => this.colors[c])
                // // Plotly.restyle('chart','marker.color',newMarkerColors)
                // Plotly.restyle('chart', { 'marker.color': [newMarkerColors] });

            },
            toggleVisibility() {
                let category = 1
                this.visibleClasses[category] = !this.visibleClasses[category]; // 切换类别的显示状态
                this.updateChart();
            },
            updateChart() {
                // 更新数据点的可见性
                const newMarkerColors = this.cell_type.map((category, index) => {
                    if (!this.visibleClasses[category]) {
                        return 'rgba(0, 0, 0, 0)'; // 设置透明颜色
                    }
                    return this.colors[category];
                });

                // 更新图表
                Plotly.restyle('chart', { 'marker.color': [newMarkerColors] });
            },
            async getcelldata(){
                const {data: res} = await this.$http.get('getcell')
                // console.log(res.data)
                this.x =  res.data.x
                this.y = res.data.y
                this.cell_type = res.data.cell_type
                // for(let i = 0; i < this.cell_type.length; ++i){
                //     this.class_num = Math.max(this.class_num,this.cell_type[i])
                // }
                // console.log(this.class_num)
                this.visibleClasses = this.cell_type.reduce((acc, category) => {
                    acc[category] = true;
                    return acc;
                }, {});
            },
            draw1(){


                this.colors = generateColors(4)
                this.cell_type = [0,1,2,3,0,1,2,3,1]
                this.visibleClasses = this.cell_type.reduce((acc, category) => {
                    acc[category] = true;
                    return acc;
                }, {});
                // console.log(this.visibleClasses)
                let markerColors = this.cell_type.map(category => this.colors[category]);
                console.log(markerColors)
                let trace = {
                    x: [1,2,3,4,-1,2,3,5,1],
                    y: [6,4,9,-1,2,3,6,3,1],
                    mode: 'markers',
                    marker: {
                        size: 10,
                        color: markerColors  // 使用映射后的颜色数组
                    },
                    // text: categories.map(c => `Category ${c}`),  // 显示类别标签
                    type: 'scattergl',
                    // type: 'scatter',
                };

                let layout = {
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
                    margin: {
                        // autoexpand: true ,
                        l: 0,
                        r: 0,
                        b: 0,
                        t: 0
                        // pad: 10
                    },
                }
                let chart = document.getElementById("chart")
                Plotly.newPlot(chart,[trace],layout)
            },
            draw() {
                console.log(this.x.length)
                console.log(this.y.length)
                this.colors = generateColors(this.class_num+1)
                // console.log(this.colors)

                let markerColors = this.cell_type.map(category => this.colors[category]);
                // console.log(this.x.length)

                let trace = {
                    x: this.x,
                    y: this.y,
                    mode: 'markers',
                    marker: {
                        size: 1,
                        color: markerColors  // 使用映射后的颜色数组
                    },
                    // text: categories.map(c => `Category ${c}`),  // 显示类别标签
                    type: 'scattergl',
                    // type: 'scatter',
                    mode: 'markers',
                };

                let layout = {
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
                    margin: {
                        // autoexpand: true ,
                        l: 0,
                        r: 0,
                        b: 0,
                        t: 0
                        // pad: 10
                    },
                }
                let chart = document.getElementById("chart")
                Plotly.newPlot(chart,[trace],layout)
            //     const layout = {
            //         // title: 'Draggable Plotly Chart',
            //         paper_bgcolor: 'black', // 设置图表外部背景为黑色
            //         plot_bgcolor: 'black',  // 设置绘图区域背景为白色
            //         font: {
            //             color: 'white', // 设置文本颜色为白色，适应黑色背景
            //         },
            //         xaxis: {
            //             showgrid: false,
            //             color: 'white',
            //             zeroline:false,
            //             // range: [-10, 10], // 初始范围
            //             autorange: true,
            //             visible: false
            //         },
            //         yaxis: {
            //             showgrid: false,
            //             zeroline: false,
            //             color: 'white',
            //             // range: [-10, 10], // 初始范围
            //             autorange: true,
            //             // ticktext: []
            //             visible: false
            //         },
            //         dragmode: 'pan',  // 设置拖动模式为 "pan"
            //         hovermode: 'closest',
            //     };
            //
            //     Plotly.newPlot('chart', [{
            //         x: [1, 2, 3],
            //         y: [2, 4, 6],
            //         type: 'scatter',
            //         mode: 'markers',
            //         marker: {
            //             color: 'white',
            //
            //
            //         },
            //     }], layout);
            },

        },
    };
</script>

<style scoped lang="less">
    .login{
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

    }
</style>
