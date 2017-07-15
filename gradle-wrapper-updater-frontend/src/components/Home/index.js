import React, { Component } from 'react';
import { Segment, Container, Header as Heading, Button, Icon } from 'semantic-ui-react'
import Login from '../Login'
import styles from './style.css';

export default class App extends Component {
  render() {
    return (
		<div>
    			<Segment secondary inverted vertical textAlign="center" className={styles.stripe}>
    				<Container>
    					<Heading inverted as='h1'>Visualise and manage Gradle versions</Heading>
    					<Heading inverted as='h2'>Visualise and manage Gradle versions</Heading>
    					<Button color='blue' size='massive' name='github'>
    				      Signup
    				    </Button>
    					<Heading inverted as='h2'>Visualise and manage Gradle versions</Heading>
				</Container>
			</Segment>
			<Segment tertiary inverted vertical textAlign="center" className={styles.stripe}>
				<Container>
				<p>Lorem ipsum dolor sit amet, consectetuer adipiscing elit. Aenean commodo ligula eget dolor. Aenean massa strong. Cum sociis natoque penatibus et magnis dis parturient montes, nascetur ridiculus mus. Donec quam felis, ultricies nec, pellentesque eu, pretium quis, sem. Nulla consequat massa quis enim. Donec pede justo, fringilla vel, aliquet nec, vulputate eget, arcu. In enim justo, rhoncus ut, imperdiet a, venenatis vitae, justo. Nullam dictum felis eu pede link mollis pretium. Integer tincidunt. Cras dapibus. Vivamus elementum semper nisi. Aenean vulputate eleifend tellus. Aenean leo ligula, porttitor eu, consequat vitae, eleifend ac, enim. Aliquam lorem ante, dapibus in, viverra quis, feugiat a, tellus. Phasellus viverra nulla ut metus varius laoreet. Quisque rutrum. Aenean imperdiet. Etiam ultricies nisi vel augue. Curabitur ullamcorper ultricies nisi.</p>
				</Container>
			</Segment>
			<Segment vertical textAlign="center" className={styles.stripe}>
				<Container>
				<p>Lorem ipsum dolor sit amet, consectetuer adipiscing elit. Aenean commodo ligula eget dolor. Aenean massa strong. Cum sociis natoque penatibus et magnis dis parturient montes, nascetur ridiculus mus. Donec quam felis, ultricies nec, pellentesque eu, pretium quis, sem. Nulla consequat massa quis enim. Donec pede justo, fringilla vel, aliquet nec, vulputate eget, arcu. In enim justo, rhoncus ut, imperdiet a, venenatis vitae, justo. Nullam dictum felis eu pede link mollis pretium. Integer tincidunt. Cras dapibus. Vivamus elementum semper nisi. Aenean vulputate eleifend tellus. Aenean leo ligula, porttitor eu, consequat vitae, eleifend ac, enim. Aliquam lorem ante, dapibus in, viverra quis, feugiat a, tellus. Phasellus viverra nulla ut metus varius laoreet. Quisque rutrum. Aenean imperdiet. Etiam ultricies nisi vel augue. Curabitur ullamcorper ultricies nisi.</p>
				</Container>
			</Segment>
		</div>
    );
  }
}
