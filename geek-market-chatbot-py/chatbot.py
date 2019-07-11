from chatterbot import ChatBot
from chatterbot.trainers import ChatterBotCorpusTrainer
from flask import Flask
from flask import json, request


chatbot = ChatBot('Ron Obvious')

# Create a new trainer for the chat bot
trainer = ChatterBotCorpusTrainer(chatbot)

# Train the chat bot based on the english corpus
trainer.train("chatterbot.corpus.english")

app = Flask(__name__)


@app.route('/')
def index():
    return 'Server Works!'


@app.route('/chatbot', methods=['GET'])
def say_hello():
    # msg = request.form['msg']
    msg = request.args.get('msg')
    resp = chatbot.get_response(msg)
    print(resp)
    data = {
        'resp': "%s" % resp
    }
    response = app.response_class(
        response=json.dumps(data),
        status=200,
        mimetype='application/json'
    )
    return response


print("Chat bot is ready!")

# Get a response to an input statement
print(chatbot.get_response("Hello, how are you today?"))

if __name__ == "__main__":
    app.run(host='0.0.0.0')
