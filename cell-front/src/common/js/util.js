function generateRandomColor() {
    // 生成一个随机的RGB颜色值
    const r = Math.floor(Math.random() * 256); // 红色分量
    const g = Math.floor(Math.random() * 256); // 绿色分量
    const b = Math.floor(Math.random() * 256); // 蓝色分量
    return `#${r.toString(16).padStart(2, '0')}${g.toString(16).padStart(2, '0')}${b.toString(16).padStart(2, '0')}`;
}

function generateColors(count) {
    const colors = [];
    for (let i = 0; i < count; i++) {
        colors.push(generateRandomColor());
    }
    return colors;
}

// const numColors = 41;
// const colors = generateColors(numColors);
//
// console.log(colors);
export {generateColors}
