import React, { useState, useEffect } from 'react';
import { format, parse, subDays, startOfMonth } from 'date-fns';
import { DateRange } from 'react-date-range';
import 'react-date-range/dist/styles.css';
import 'react-date-range/dist/theme/default.css';
import ChartComponent from './ChartComponent.tsx';

const Dashboard = ({ name, containerStyle, onClickDashboardItem }) => {
  const [dashboard, setDashboard] = useState(null);
  const [filteredData, setFilteredData] = useState(null);
  const [filteredRange, setFilteredRange] = useState([
    {
      startDate: new Date(),
      endDate: new Date(),
      key: 'selection'
    }
  ]);

  const [range, setRange] = useState([
    {
      startDate: new Date(),
      endDate: new Date(),
      key: 'selection'
    }
  ]);

  const presets = [
    { label: 'CURRENT_MONTH', range: { startDate: startOfMonth(new Date()), endDate: new Date(), key: 'selection' } },
    { label: 'LAST_30_DAYS', range: { startDate: subDays(new Date(), 30), endDate: new Date(), key: 'selection' } },
    { label: 'LAST_90_DAYS', range: { startDate: subDays(new Date(), 90), endDate: new Date(), key: 'selection' } }
  ];

  const isWithinRange = (selectedRange, currentRange) => {

    const selectedStart = format(selectedRange.startDate, 'yyyy-MM-dd');
    const selectedEnd = format(selectedRange.endDate, 'yyyy-MM-dd');
    const currentStart = format(currentRange.startDate, 'yyyy-MM-dd');
    const currentEnd = format(currentRange.endDate, 'yyyy-MM-dd');

    console.log(selectedStart, selectedEnd);
    console.log(selectedStart >= currentStart &&
        selectedEnd <= currentEnd);
    return (
      selectedStart >= currentStart &&
      selectedEnd <= currentEnd
    );
  };

  const filterDataByRange = (presentData, range) => {
    const { startDate, endDate } = range;
    // console.log(data.charts);
    const filteredCharts = presentData.charts.map(chart => ({
        ...chart,
        data: chart.data.filter(item => {
            const dateField = chart.dateField;
          return item[dateField] >= format(startDate, 'yyyy-MM-dd') && item[dateField] <= format(endDate, 'yyyy-MM-dd');
        })
      }));
      
      console.log(filteredCharts);
      return { ...presentData, charts: filteredCharts };
  };

  const handlePresetClick = (preset) => {
    if(!isWithinRange(preset.range, range[0])){
        const startParsed = new Date(preset.range.startDate.toString());
        const formattedStartParse = format(startParsed, 'yyyy-MM-dd');
        const endParsed = new Date(preset.range.endDate.toString());
        const formattedEndParse = format(endParsed, 'yyyy-MM-dd');
        getDashboardData(formattedStartParse, formattedEndParse);
        setRange([preset.range]);
    }
    else if(dashboard){
        const filtered = filterDataByRange(dashboard, preset.range);
        setFilteredData(filtered);
    }
    setFilteredRange([preset.range]);
  };

  const handleSelect = (item) => {
    if (!isWithinRange(item.selection, range[0])) {
        const startParsed = format(item.selection.startDate, 'yyyy-MM-dd');
        const endParsed = format(item.selection.endDate, 'yyyy-MM-dd');
        getDashboardData(startParsed, endParsed);
      } else if (dashboard) {
        const filtered = filterDataByRange(dashboard, item.selection);
        setFilteredData(filtered);
      }
      setFilteredRange([item.selection]);
  };

  const getDashboardData = async (start, end) => {
    var url = `http://localhost:8080/dashboard/${name}`;
    var setRangeValue = true;
    if (start !== "" && end != "") {
      url = `http://localhost:8080/dashboard/${name}?updateEndDate=${end}&updateStartDate=${start}`;
      setRangeValue = false;
    }
    console.log(url);
    try {
      const response = await fetch(url);
      const data = await response.json();
      setDashboard(data);
      setFilteredData(data);
      if (data.initialDateRange && setRangeValue){
        const matchedPreset = presets.find(preset => preset.label.toLowerCase() === data.initialDateRange.toLowerCase());
        if (matchedPreset) {
          setRange([matchedPreset.range]);
          setFilteredRange([matchedPreset.range]);
        }
      }
    } catch (error) {
      console.log(url, error);
    }
  };

  useEffect(() => {
    getDashboardData("","");
  }, []);

  return (
    <div style={containerStyle}>
      <div style={{ marginBottom: '20px' }}>
        {presets.map((preset) => (
          <button
            key={preset.label}
            onClick={() => handlePresetClick(preset)}
            style={{ marginRight: '10px' }}
          >
            {preset.label}
          </button>
        ))}
      </div>
      <DateRange
        editableDateInputs={true}
        onChange={handleSelect}
        moveRangeOnFirstSelection={false}
        ranges={filteredRange}
      />
      <div>
        {dashboard ? (
          <div>
            <h1>{dashboard.name}</h1>
            {filteredData && filteredData.charts ? (
              filteredData.charts.map((chart, index) => (
                <div onClick={onClickDashboardItem}>
                    <ChartComponent key={index} chart={chart} />
                </div>
              ))
            ) : (
              <p>No data available for the selected range.</p>
            )}
          </div>
        ) : (
          <p>Loading...</p>
        )}
      </div>
    </div>
  );
};

export default Dashboard;



