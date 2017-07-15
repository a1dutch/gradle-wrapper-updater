import React, { Component } from 'react';
import { Segment, Container, Grid, Icon } from 'semantic-ui-react'
import ButtonLink from '../ButtonLink'

export default class Footer extends Component {
	render() {
		return (
			<Segment vertical inverted>
				<Container className='footer'>
  					<Grid stackable columns='2'>
  						<Grid.Column floated='left'>
  							&copy; 2017 <ButtonLink href="http://a1dutch.co.uk">Andrew Holland</ButtonLink>
  						</Grid.Column>
  						<Grid.Column floated='right' textAlign='right'>
  							<Icon link name='github' size='large' />
  						</Grid.Column>
  					</Grid>
				</Container>
			</Segment>
		);
	}
}
