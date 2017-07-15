import React, { Component } from 'react';
import Grid from 'material-ui/Grid';
import Card, { CardActions, CardContent, CardMedia } from 'material-ui/Card';

const styles = {
  hero: {
    "max-width": "100%",
    height: "auto",
  },
};

class Hero extends Component {
  render() {
	  return(
		  <Grid item xs={12} md={8} lg={8}>
			  <Card >
		        <CardMedia>
		          <img style={styles.hero} src="http://placeholder.pics/svg/1200x200" alt="Contemplative Reptile" />
		        </CardMedia>
		          </Card>
		  </Grid>
	  );
  }
}

export default Hero;
