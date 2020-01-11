import React, { Component } from 'react'

export default class Form extends Component {
    constructor(props){
        super(props)
        this.initialState ={
            name: '',
            job:''
        }
        this.state = this.initialState;
    }

    handleChange = event =>{
        const {name, value} = event.target;
        this.setState({
            [name]: value
        })
    }

    submitForm = () =>{
        this.props.handleSubmit(this.state);
        this.setState(this.initialState);
    }
    render() {

        const{name, job} = this.state;
        return (
            <form>
                <input type="text" name="name" id="name" value={name} placeholder="enter name here" onChange={this.handleChange} />
                <input type="text" name="job" id="job" value={job} placeholder="enter Job here" onChange={this.handleChange} />
                <input type="button" value="Submit" onClick={this.submitForm} />
            </form>
        )
    }
}
