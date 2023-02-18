
module.exports = (req, res, next) => {
    console.log(req.body.email)
    var send = res.send;
    res.send = function (string) {
        var body = string instanceof Buffer ? string.toString() : string;
        body = body.replace(/access_/, "");
        send.call(this, body);
    };
    next()
}