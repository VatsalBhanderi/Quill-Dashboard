import React from 'react';
import { LineChart, Line, BarChart, Bar, XAxis, YAxis, CartesianGrid, Tooltip, Legend, ResponsiveContainer } from 'recharts';

const ChartComponent = ({ chart }) => {
  const { chartType, data, xName, yName, chartName } = chart;
  // console.log("Inside ChartCOmponent", chartType, data, xName, yName, chartName);
  return (
    <div style={{ margin: '20px 0' }}>
      <h3>{chartName}</h3>
      {chartType === 'line' ? (
        <LineChart width={600} height={300} data={data} margin={{right: 30}}>
          <XAxis dataKey={xName} />
          <YAxis />
          <CartesianGrid strokeDasharray="3 3" />
          <Tooltip />
          <Legend />
          <Line type="monotone" dataKey={yName} stroke="#8884d8" />
        </LineChart>
      ) : (
        
          <BarChart width={600} height={300} data={data} margin={{right: 30}}>
          <XAxis dataKey={xName} />
          <YAxis />
          <CartesianGrid strokeDasharray="3 3" />
          <Tooltip />
          <Legend />
          <Bar dataKey={yName} fill="#8884d8" />
        </BarChart>
       
      )}
    </div>
  );
};

export default ChartComponent;
