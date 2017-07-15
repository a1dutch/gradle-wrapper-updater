import React, { Component } from 'react';
import { Segment, Menu, Container} from 'semantic-ui-react'
import Header from '../Header';
import Footer from '../Footer';

export default class Layout extends Component {
	render() {
		return (
			<div>
				<Header />
				{ this.props.children }
				<Footer />
			</div>
		);
	}
}