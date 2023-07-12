document.addEventListener('DOMContentLoaded', function() {
	new Chart(document.getElementById("myPieChart"), {
		type: 'pie',
		data: {
			labels: ['Green', 'Blue', 'Yellow'],
			datasets: [{
				label: 'my dataset',
				data: [5, 5, 10],
				backgroundColor: ['green', 'blue', 'yellow']
			}]
		},
		options: {
			responsive: true,
			maintainAspectRatio: false
		}
	});
});
