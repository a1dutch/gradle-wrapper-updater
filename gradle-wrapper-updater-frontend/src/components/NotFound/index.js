import React, { PropTypes, Component } from 'react';
import { Segment, Container, Header, Button } from 'semantic-ui-react'

import styles from './style.css';

export default class NotFound extends Component {
  render() {
    const { className, ...props } = this.props;
    return (
			<Segment secondary inverted vertical textAlign="center" className={styles.stripe}>
				<Container>
					<Header inverted as='h2' className={styles.error}>Oops!!</Header>
					<Header inverted as='h1' className={styles.error}>404</Header>
					<Header inverted as='h2' className={styles.error}>We are unable to find the page you are looking for.</Header>
			</Container>
		</Segment>
    );
  }
}