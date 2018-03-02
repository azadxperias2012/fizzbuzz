<%@ include file="./common/header.jspf"%>

    <div class="container">
        <div class="jumbotron">
            <h1 class="display-4">Welcome to FizzBuzz Application</h1>
            <p class="lead">This is a group word game for children to teach them about division.</p>
            <hr class="my-4">
            <p>Players take turns to count incrementally, replacing any number divisible by three with the word "fizz", and any number divisible by five with the word "buzz".</p>
            <p class="lead">
                <a class="btn btn-primary btn-sm" href="https://en.wikipedia.org/wiki/Fizz_buzz"
                   role="button" target="_blank">Learn more</a>
            </p>
        </div>
        <form class="form" action="/getFirstHundred.do" method="get">
            <div class="row">
                <div class="col">
                    <input type="number" class="form-control" name="limit"
                           placeholder="Input a limit either positive or negative">
                </div>
                <div class="col-2">
                    <button type="submit" class="btn btn-primary btn-block">Get</button>
                </div>
            </div>

        </form>

        <div class="row mt-4 mb-4 ml-2 mr-2">
            <div class="col">
                <c:if test="${limit != null}">
                    <c:choose>
                        <c:when test="${limit == \"0\"}">
                            <h1 class="display-4">Enter limit other than "0" or "Empty"</h1>
                        </c:when>
                        <c:otherwise>
                            <h1 class="display-4">Results for limit: ${limit}</h1>
                            <div>${result}</div>
                        </c:otherwise>
                    </c:choose>
                </c:if>
            </div>
        </div>
    </div>


<%@ include file="./common/footer.jspf"%>
