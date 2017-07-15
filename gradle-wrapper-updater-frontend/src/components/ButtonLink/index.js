import React from 'react'
import { Button } from 'semantic-ui-react'
import styles from './style.css';

const ButtonLink = ({
  className = '',
  color = 'blue',
  ...props
}) => <Button
  basic
  color={color}
  className={styles.link}
  {...props}
/>

ButtonLink.propTypes = {
  className: React.PropTypes.string,
  color: React.PropTypes.string
}

export default ButtonLink