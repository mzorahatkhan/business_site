document.addEventListener('DOMContentLoaded', function() {
	new Chart(document.getElementById("myPieChart"), {
		type: 'pie',
		data: {
			labels: ['Brown', 'Blue', 'Black'],
			datasets: [{
				label: 'my dataset',
				data: [5, 5, 10],
				backgroundColor: ['brown', 'blue', 'black']
			}]
		},
		options: {
			responsive: true,
			maintainAspectRatio: false
		}
	});
});
