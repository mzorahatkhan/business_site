
var chartDataStr = decodeMyHtml(productChartData);
var chartDataJson = JSON.parse(chartDataStr);

var numericData = [];
var labelData = [];
var backColor=[];
var lengthProdCount = chartDataJson.length;

for (i = 0; i < lengthProdCount; i++) {
	numericData[i] = chartDataJson[i].productCount;
	labelData[i] = chartDataJson[i].label;
	//looping background color text according with the label
	backColor[i]=chartDataJson[i].label;

}


//For a pie chart 
new Chart(document.getElementById("myPieChart"), {
	type: 'pie',
	data: {
		labels: labelData,
		datasets: [{
			label: 'Product Count',
			data: numericData,
			backgroundColor: backColor
		}]
	},
	options: {
		responsive: true,
		maintainAspectRatio: false,
		plugins: {
			title: {
				display: true,
				text: 'Product Number Wtih  Color',
				font: {
					size: 20,
					weight: 'bold'
				}
			}
		}
	}
});

//to decode the innter html that comeds from the mode as json string 
function decodeMyHtml(html) {
	var txt = document.createElement("textarea");// creating and element and assign to a textarea
	txt.innerHTML = html;
	return txt.value;

}
