// Define SVG area dimensions
var svgWidth = 960;
var svgHeight = 660;

// Define the chart's margins as an object
var chartMargin = {
  top: 30,
  right: 30,
  bottom: 30,
  left: 30
};

// Define dimensions of the chart area
var chartWidth = svgWidth - chartMargin.left - chartMargin.right;
var chartHeight = svgHeight - chartMargin.top - chartMargin.bottom;

// Select body, append SVG area to it, and set the dimensions
var svg = d3
  .select("body")
  .append("svg")
  .attr("height", svgHeight)
  .attr("width", svgWidth);

  d3.json("http://localhost:8090/api/physiciansByState", function(d) {
      var counts = {};
      d.data.forEach(function(d) {
        // Retrieve the keywords from the JSON API response and count frequency of each one across all search results
        console.log(d);
        arr = d.attributes.keywords
        for(var i = 0; i<arr.length; i++) {
          var num = arr[i];
          counts[num] = counts[num] ? counts[num]+1 : 1;
        };
      });
      // console.log(counts)

      // Create array of objects of search results to be used by D3
      var data = [];
      for(var key in counts) {
        var val = counts[key];
        data.push({
          count: val,
          keyword: key
        });
      }
      console.log(data);
      });