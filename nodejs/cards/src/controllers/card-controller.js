const { request, response } = require('express')
const neDB = require('../configurations/database')
const api = {}

api.findAll = (request, response) => {
    neDB.find({}).sort({ name: 1}).exec((exception, cards) => {
        if(exception) {
            const setence = 'Could not list the cards!'
            console.log(setence, exception)
            response.status(exception)
            response.json({ 'mensagem': setence })
        }
        response.json(cards)
    })
}

api.save = (request, response) => {
    const  canonical= request.body
    neDB.insert(canonical, (exception, card) => {
        if(exception) {
            const setence = "Could not list the cards!"
            console.log(setence, exception)
            response.status(exception.status | 400)
            response.json({ 'mensagem': setence })
        }

        response.status(201)
        response.json(card)
    })
}

api.delete = (request, response) => {
    card.findByIdAndDelete(request.params.id)
    .then((card) => {
        if(!card) {
            return response.status(404).send({ message: `Card Not Found ${request.params.id}`})
        }

        response.status(200).send({ message: `Card deleted successfully `, card})
    }).catch((err) => {
        if (err.kind === 'ObjectId') {
            return response.status(404).send({ message: `Card not found ${request.params.id}`})
        }
        
        return response.status(500).send({ message: `Error ${request.params.id}`})
    })
}


module.exports = api