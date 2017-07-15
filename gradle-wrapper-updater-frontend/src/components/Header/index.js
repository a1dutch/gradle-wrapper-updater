import React, { Component } from 'react';
import { Segment, Menu, Container} from 'semantic-ui-react'
//import Login from '../Login'
import { Link } from 'react-router-dom'

export default class Header extends Component {
	
	state = {}	

	handleItemClick = (e, { name }) => this.setState({ activeItem: name })
	
	render() {
		const { activeItem } = this.state

		return (
			<Segment vertical inverted>
				<Container className="header">
	  				<Menu inverted size="massive">
	      				<Menu.Item header href='/'>Logo</Menu.Item>
	      				<Menu.Item
			          		name='login'
		          			content='Login | Signup'
	          				active={activeItem === 'login'}
			          		onClick={this.handleItemClick}
			  		 		position='right'
	      					href='https://github.com/login/oauth/authorize?client_id=cf1f4633c4a07fb2c1d4&redirect_uri=http://a1dutch.co.uk/api/oauth/github&scope=user:email%20repo'
	  		 			/>
		 			</Menu>
				</Container>
			</Segment>
		);
	}
}
