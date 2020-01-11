import React, { Component } from 'react';

import './App.css';
import Table from './Components/Table';
import Form from './Components/Form'

class App extends Component {

  state={
    characters:
    [
        {
          name: 'Charlie',
          job: 'Janitor',
        },
        {
          name: 'Mac',
          job: 'Bouncer',
        },
        {
          name: 'Dee',
          job: 'Aspring actress',
        },
        {
          name: 'Dennis',
          job: 'Bartender',
        },
      ]
  };

  handleSubmit = character =>{
    this.setState({characters: [...this.state.characters, character]})
  }


removeCharacter = index =>{
  const {characters} = this.state;
  this.setState({
    characters: characters.filter((character, i) =>{

      return i !==index;
    })
  });
}
  render(){
    const {characters} = this.state;
    return (
     
      <div className="App">
          <Table characterData ={characters} removeCharacter = {this.removeCharacter}/>
          <Form handleSubmit = {this.handleSubmit}/>
      </div>
    );

  }

}

export default App;
