import React from 'react';
import { render } from 'react-dom';
import Home from './components/Home';
import NotFound from './components/NotFound'
import Layout from './components/Layout'
import registerServiceWorker from './registerServiceWorker';
import './style.css';
import { BrowserRouter as Router, Route, Link, Switch } from 'react-router-dom'

render((
	<Router>
		<div>
			<Layout>
				<Switch>
					<Route path="/" exact component={Home}/>
					<Route component={NotFound}/>
				</Switch>
			</Layout>
		</div>
	</Router>
), document.getElementById('app'));

registerServiceWorker();
