'use strict';

import logMsg from './utils/log.es';
import Chart from './chartjs-color'; 
//import polyfillBabel from 'polyfill-babel';

class Logger {
	constructor(shellPrompt = '|> ') {
		this.shellPrompt = shellPrompt;
	}

	log(msg) {
		let shellMessage = `${this.shellPrompt} ${msg}`;
		console.log("ceci est un test2...");
		logMsg(shellMessage);
		console.log(shellMessage);
	}
	
	draw(elementId){

		console.log("afficher dans " + elementId);
		var ctx = document.getElementById(elementId);
		var myChart = new Chart(ctx, {
		    type: 'bar',
		    data: {
		        labels: ["Red", "Blue", "Yellow", "Green", "Purple", "Orange"],
		        datasets: [{
		            label: '# of Votes',
		            data: [12, 19, 3, 5, 2, 3],
		            backgroundColor: [
		                'rgba(255, 99, 132, 0.2)',
		                'rgba(54, 162, 235, 0.2)',
		                'rgba(255, 206, 86, 0.2)',
		                'rgba(75, 192, 192, 0.2)',
		                'rgba(153, 102, 255, 0.2)',
		                'rgba(255, 159, 64, 0.2)'
		            ],
		            borderColor: [
		                'rgba(255,99,132,1)',
		                'rgba(54, 162, 235, 1)',
		                'rgba(255, 206, 86, 1)',
		                'rgba(75, 192, 192, 1)',
		                'rgba(153, 102, 255, 1)',
		                'rgba(255, 159, 64, 1)'
		            ],
		            borderWidth: 1
		        }]
		    },
		    options: {
		        scales: {
		            yAxes: [{
		                ticks: {
		                    beginAtZero:true
		                }
		            }]
		        }
		    }
		});
		
	}
}

export default Logger;